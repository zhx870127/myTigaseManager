package com.letv.tigase.domain.query;

import java.util.Date;

import com.letv.common.utils.page.Query;

/**
 * TigPubsubJidsQuery：查询类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class TigPubsubJidsQuery extends Query {
    
    /**  */
	private Long jidId; 
    /**  */
	private String jid; 
    /**  */
	private String jidSha1; 
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
	
    public String getJidSha1(){
		return jidSha1;
	}
	    
    public void setJidSha1(String jidSha1) {
		this.jidSha1 = jidSha1;
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
