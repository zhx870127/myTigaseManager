package com.letv.tigase.domain.query;

import java.util.Date;

import com.letv.common.utils.page.Query;

/**
 * TigMaMsgsQuery：查询类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class TigMaMsgsQuery extends Query {
    
    /**  */
	private Long msgId; 
    /**  */
	private Long ownerId; 
    /**  */
	private Long buddyId; 
    /**  */
	private Date ts; 
    /**  */
	private Integer direction; 
    /**  */
	private String type; 
    /**  */
	private String body; 
    /**  */
	private String msg; 
    /** 开始时间 */
    private Date startTime; 
    /** 结束时间 */
    private Date endTime; 
	
    public Long getMsgId(){
		return msgId;
	}
	    
    public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}
	
    public Long getOwnerId(){
		return ownerId;
	}
	    
    public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	
    public Long getBuddyId(){
		return buddyId;
	}
	    
    public void setBuddyId(Long buddyId) {
		this.buddyId = buddyId;
	}
	
    public Date getTs(){
		return ts;
	}
	    
    public void setTs(Date ts) {
		this.ts = ts;
	}
	
    public Integer getDirection(){
		return direction;
	}
	    
    public void setDirection(Integer direction) {
		this.direction = direction;
	}
	
    public String getType(){
		return type;
	}
	    
    public void setType(String type) {
		this.type = type;
	}
	
    public String getBody(){
		return body;
	}
	    
    public void setBody(String body) {
		this.body = body;
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
