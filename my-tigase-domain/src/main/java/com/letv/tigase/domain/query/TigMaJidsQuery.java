package com.letv.tigase.domain.query;

import java.util.Date;

import com.letv.common.utils.page.Query;

/**
 * TigMaJidsQuery：查询类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class TigMaJidsQuery extends Query {
    
    /**  */
	private Long jidId; 
    /**  */
	private String jid; 
    /** 开始时间 */
    private Date startTime; 
    /** 结束时间 */
    private Date endTime; 
	
    public Long getJidId(){
		return jidId;
	}
	    
    public void setJidId(Long jidId) {
		this.jidId = jidId;
	}
	
    public String getJid(){
		return jid;
	}
	    
    public void setJid(String jid) {
		this.jid = jid;
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
