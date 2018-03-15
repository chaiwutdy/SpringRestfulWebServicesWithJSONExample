package org.arpit.java2blog.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.arpit.java2blog.bean.NDCReceivedModel;
import org.arpit.java2blog.dao.TNDCReceivedDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("tNDCReceivedDAO")
public class TNDCReceivedDAOImpl implements TNDCReceivedDAO{

	@Autowired
    private JdbcTemplate jdbcTemplate;
 
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
	    
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<NDCReceivedModel> getTNDCReceiveds() {
		String sql ="SELECT * FROM T_NDCRECEIVED WHERE RECEIVEDDT LIKE '%11/2017%'";
		return getJdbcTemplate().query(sql,  new BeanPropertyRowMapper(NDCReceivedModel.class));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<NDCReceivedModel> getTNDCReceiveds(String frameno, String receivedDate) {
		List<String> params = new ArrayList<String>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM T_NDCRECEIVED ");
		sql.append("WHERE 1=1 ");
		if(frameno != null && !frameno.isEmpty()){
			sql.append("AND FRAMENO = ? ");
			params.add(frameno);
		}
		
		if(receivedDate != null && !receivedDate.isEmpty()){
			sql.append("AND RECEIVEDDATE = ? ");
			params.add(receivedDate);
		}
		
		System.out.println(sql.toString());
		System.out.println(params.toString());
		return getJdbcTemplate().query(sql.toString(), params.toArray(), new BeanPropertyRowMapper(NDCReceivedModel.class));
	}

	public int updateTNDCReceivedStatus(String frameNo,String status) {
		String sql ="UPDATE T_NDCRECEIVED SET STATUS = ? WHERE FRAMENO = ? ";
		List<String> params = new ArrayList<String>();
		params.add(frameNo);
		params.add(status);
		System.out.println(sql);
		System.out.println(params.toString());
		return getJdbcTemplate().update(sql, params.toArray());
	}

	@SuppressWarnings("static-access")
	public int createTNDCReceived(NDCReceivedModel obj) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO T_NDCRECEIVED ( ");
		sql.append("OID, FRAMENO, ENGINENO ");
		sql.append(") VALUES ( ?, ?, ?) ");
		List<String> params = new ArrayList<String>();
		params.add(new UUID(32, 32).randomUUID().toString());
		params.add(obj.getFrameno());
		params.add("R20A35011032");
		return getJdbcTemplate().update(sql.toString(), params.toArray());
	}
	
	public int deleteTNDCReceived(String frameNo) {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM T_NDCRECEIVED WHERE FRAMENO = ? ");
		List<String> params = new ArrayList<String>();
		params.add(frameNo);
		return getJdbcTemplate().update(sql.toString(), params.toArray());
	}

}
