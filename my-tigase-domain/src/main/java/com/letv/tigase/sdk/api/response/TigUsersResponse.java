package com.letv.tigase.sdk.api.response;

import com.letv.common.sdk.api.LetvObject;
import java.util.Date;

/**
 * TigUsersResponse：返回对象<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class TigUsersResponse implements LetvObject {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /**  */
    private Long uid; 
    /**  */
    private String userId; 
    /**  */
    private String sha1UserId; 
    /**  */
    private String userPw; 
    /**  */
    private Date accCreateTime; 
    /**  */
    private Date lastLogin; 
    /**  */
    private Date lastLogout; 
    /**  */
    private Integer onlineStatus; 
    /**  */
    private Integer failedLogins; 
    /**  */
    private Integer accountStatus; 
    
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
    
    public String getUserPw(){
        return userPw;
    }
        
    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }
    
    public Date getAccCreateTime(){
        return accCreateTime;
    }
        
    public void setAccCreateTime(Date accCreateTime) {
        this.accCreateTime = accCreateTime;
    }
    
    public Date getLastLogin(){
        return lastLogin;
    }
        
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
    
    public Date getLastLogout(){
        return lastLogout;
    }
        
    public void setLastLogout(Date lastLogout) {
        this.lastLogout = lastLogout;
    }
    
    public Integer getOnlineStatus(){
        return onlineStatus;
    }
        
    public void setOnlineStatus(Integer onlineStatus) {
        this.onlineStatus = onlineStatus;
    }
    
    public Integer getFailedLogins(){
        return failedLogins;
    }
        
    public void setFailedLogins(Integer failedLogins) {
        this.failedLogins = failedLogins;
    }
    
    public Integer getAccountStatus(){
        return accountStatus;
    }
        
    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }
}
