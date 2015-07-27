package com.letv.test.tigase.rest.dto;

import com.letv.common.sdk.api.LetvObject;
import java.util.Date;

/**
 * TigSocks5UsersResponse：返回对象<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class TigSocks5Users implements LetvObject {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
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
}
