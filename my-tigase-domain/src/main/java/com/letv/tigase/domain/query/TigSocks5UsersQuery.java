package com.letv.tigase.domain.query;

import java.util.Date;

import com.letv.common.utils.page.Query;

/**
 * TigSocks5UsersQuery：查询类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class TigSocks5UsersQuery extends Query {
    
    /**  */
	private Long uid; 
    /**  */
	private String userId; 
    /**  */
	private String sha1UserId; 
    /**  */
	private String domain; 
    /**  */
	private String sha1Domain; 
    /**  */
	private Long filesizeLimit; 
    /**  */
	private Long transferLimitPerUser; 
    /**  */
	private Long transferLimitPerDomain; 
    /** 开始时间 */
    private Date startTime; 
    /** 结束时间 */
    private Date endTime; 
	
    public Long getUid(){
		return uid;
	}
	    
    public void setUid(Long uid) {
		this.uid = uid;
	}
	
    public String getUserId(){
		return userId;
	}
	    
    public void setUserId(String userId) {
		this.userId = userId;
	}
	
    public String getSha1UserId(){
		return sha1UserId;
	}
	    
    public void setSha1UserId(String sha1UserId) {
		this.sha1UserId = sha1UserId;
	}
	
    public String getDomain(){
		return domain;
	}
	    
    public void setDomain(String domain) {
		this.domain = domain;
	}
	
    public String getSha1Domain(){
		return sha1Domain;
	}
	    
    public void setSha1Domain(String sha1Domain) {
		this.sha1Domain = sha1Domain;
	}
	
    public Long getFilesizeLimit(){
		return filesizeLimit;
	}
	    
    public void setFilesizeLimit(Long filesizeLimit) {
		this.filesizeLimit = filesizeLimit;
	}
	
    public Long getTransferLimitPerUser(){
		return transferLimitPerUser;
	}
	    
    public void setTransferLimitPerUser(Long transferLimitPerUser) {
		this.transferLimitPerUser = transferLimitPerUser;
	}
	
    public Long getTransferLimitPerDomain(){
		return transferLimitPerDomain;
	}
	    
    public void setTransferLimitPerDomain(Long transferLimitPerDomain) {
		this.transferLimitPerDomain = transferLimitPerDomain;
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
