package org.arpit.java2blog.service;

import java.util.List;

import org.arpit.java2blog.bean.NDCReceivedModel;
import org.arpit.java2blog.dao.TNDCReceivedDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ndcService")
public class NdcService {

	@Autowired
	private TNDCReceivedDAO tNDCReceivedDAO;
	
	public List<NDCReceivedModel> getTNDCReceiveds(){
		return tNDCReceivedDAO.getTNDCReceiveds();
	}
	
	public List<NDCReceivedModel> getTNDCReceiveds(String frameno, String receivedDate){
		return tNDCReceivedDAO.getTNDCReceiveds(frameno, receivedDate);
	}
	
	public int updateTNDCReceivedStatus(String frameNo,String status){
		return tNDCReceivedDAO.updateTNDCReceivedStatus(frameNo, status);
	}
	
	public int createTNDCReceived(NDCReceivedModel model){
		return tNDCReceivedDAO.createTNDCReceived(model);
	}
	
	public int deleteTNDCReceived(String frameNo){
		return tNDCReceivedDAO.deleteTNDCReceived(frameNo);
	}
}
