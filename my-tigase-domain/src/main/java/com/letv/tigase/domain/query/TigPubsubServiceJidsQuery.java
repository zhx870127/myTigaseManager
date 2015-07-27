package com.letv.tigase.domain.query;

import java.util.Date;

import com.letv.common.utils.page.Query;

/**
 * TigPubsubServiceJidsQuery：查询类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class TigPubsubServiceJidsQuery extends Query {
    
    /**  */
	private Long serviceId; 
    /**  */
	private String serviceJid; 
    /**  */
	private String serviceJidSha1; 
    /** 开始时间 */
    private Date startTime; 
    /** 结束时间 */
    private Date endTime; 
	
    public Long getServiceId(){
		return serviceId;
	}
	    
    public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	
    public String getServiceJid(){
		return serviceJid;
	}
	    
    public void setServiceJid(String serviceJid) {
		this.serviceJid = serviceJid;
	}
	
    public String getServiceJidSha1(){
		return serviceJidSha1;
	}
	    
    public void setServiceJidSha1(String serviceJidSha1) {
		this.serviceJidSha1 = serviceJidSha1;
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
