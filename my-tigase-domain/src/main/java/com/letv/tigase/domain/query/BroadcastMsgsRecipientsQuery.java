package com.letv.tigase.domain.query;

import java.util.Date;

import com.letv.common.utils.page.Query;

/**
 * BroadcastMsgsRecipientsQuery：查询类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class BroadcastMsgsRecipientsQuery extends Query {
    
    /**  */
	private String msgId; 
    /**  */
	private Long jidId; 
    /** 开始时间 */
    private Date startTime; 
    /** 结束时间 */
    private Date endTime; 
	
    public String getMsgId(){
		return msgId;
	}
	    
    public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
    public Long getJidId(){
		return jidId;
	}
	    
    public void setJidId(Long jidId) {
		this.jidId = jidId;
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
