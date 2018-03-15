package org.arpit.java2blog.controller;

import java.util.List;

import org.arpit.java2blog.bean.NDCReceivedModel;
import org.arpit.java2blog.service.NdcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class NDCController {
	
	@Autowired
	private NdcService ndcService;
	
	@RequestMapping(value="/ndcreceiveds",method=RequestMethod.GET,produces = "application/json")
	public List<NDCReceivedModel> ndcreceiveds(){
		List<NDCReceivedModel> result = ndcService.getTNDCReceiveds();
		return result;
	}
	
	@RequestMapping(value="/ndcreceiveds",method=RequestMethod.GET,
			params = {"frameno", "receivedDate"},
			produces = "application/json")
	public List<NDCReceivedModel> ndcreceiveds(@RequestParam(value = "frameno") String frameno,
			@RequestParam(value = "receivedDate") String receivedDate){
		System.out.println("frameno:"+frameno );
		System.out.println("receivedDate:"+receivedDate );
		List<NDCReceivedModel> result = ndcService.getTNDCReceiveds(frameno,receivedDate);
		return result;
	}
	
	/*@RequestMapping(value="/ndcreceiveds2",method=RequestMethod.GET,produces = "application/json")
	public String ndcreceiveds2(){
	  return "{\"results\": ["+
      "\"Item 1\","+
      "\"Item 2\","+
      "\"Item 3\","+
      "\"Item 4\","+
      "\"Item 5\""+
    "]}";
	}*/
	
	@RequestMapping(value="/saveNdcreceivedStatus",method=RequestMethod.PUT)
	public int saveNdcreceivedStatus(@RequestBody NDCReceivedModel model){
		System.out.println("model.getFrameno():"+model.getFrameno() );
		return ndcService.updateTNDCReceivedStatus(model.getFrameno(), model.getStatus());
	}
	
	@RequestMapping(value="/createNdcreceived",method=RequestMethod.POST)
	public int createTNDCReceived(@RequestBody NDCReceivedModel model){
		System.out.println("model.getFrameno():"+model.getFrameno() );
		return ndcService.createTNDCReceived(model);
	}
	
	@RequestMapping(value="/deleteNdcreceived/{frameNo}",method=RequestMethod.DELETE)
	public int deleteTNDCReceived(@PathVariable("frameNo") String frameNo){
		System.out.println("frameNo:"+frameNo );
		return ndcService.deleteTNDCReceived(frameNo);
	}
}
