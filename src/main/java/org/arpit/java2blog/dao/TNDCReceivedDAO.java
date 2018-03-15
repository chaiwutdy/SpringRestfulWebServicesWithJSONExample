package org.arpit.java2blog.dao;

import java.util.List;

import org.arpit.java2blog.bean.NDCReceivedModel;

public interface TNDCReceivedDAO {

	public List<NDCReceivedModel> getTNDCReceiveds();
	public List<NDCReceivedModel> getTNDCReceiveds(String frameno, String receivedDate);
	public int updateTNDCReceivedStatus(String frameNo,String status);
	public int createTNDCReceived(NDCReceivedModel model);
	public int deleteTNDCReceived(String frameNo);
}
