package com.letv.tigase.domain.query;

import java.util.Date;

import com.letv.common.utils.page.Query;

/**
 * BroadcastMsgsQuery：查询类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class BroadcastMsgsQuery extends Query {
    
    /**  */
	private String id; 
    /**  */
	private Date expired; 
    /**  */
	private String msg; 
    /** 开始时间 */
    private Date startTime; 
    /** 结束时间 */
    private Date endTime; 
	
    public String getId(){
		return id;
	}
	    
    public void setId(String id) {
		this.id = id;
	}
	
    public Date getExpired(){
		return expired;
	}
	    
    public void setExpired(Date expired) {
		this.expired = expired;
	}
	
    public String getMsg(){
		return msg;
	}
	    
    public void setMsg(String msg) {
		this.msg = msg;
	}

    public Date getStartTime() {
        return startTime;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    public Date getEndTime() {
        return endTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
