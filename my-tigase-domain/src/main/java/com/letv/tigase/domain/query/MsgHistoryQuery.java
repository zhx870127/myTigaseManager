package com.letv.tigase.domain.query;

import java.util.Date;

import com.letv.common.utils.page.Query;

/**
 * MsgHistoryQuery：查询类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class MsgHistoryQuery extends Query {
    
    /**  */
	private Long msgId; 
    /**  */
	private Date ts; 
    /**  */
	private Date expired; 
    /**  */
	private Long senderUid; 
    /**  */
	private Long receiverUid; 
    /**  */
	private Integer msgType; 
    /**  */
	private String message; 
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
	
    public Date getTs(){
		return ts;
	}
	    
    public void setTs(Date ts) {
		this.ts = ts;
	}
	
    public Date getExpired(){
		return expired;
	}
	    
    public void setExpired(Date expired) {
		this.expired = expired;
	}
	
    public Long getSenderUid(){
		return senderUid;
	}
	    
    public void setSenderUid(Long senderUid) {
		this.senderUid = senderUid;
	}
	
    public Long getReceiverUid(){
		return receiverUid;
	}
	    
    public void setReceiverUid(Long receiverUid) {
		this.receiverUid = receiverUid;
	}
	
    public Integer getMsgType(){
		return msgType;
	}
	    
    public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}
	
    public String getMessage(){
		return message;
	}
	    
    public void setMessage(String message) {
		this.message = message;
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
