package com.letv.tigase.sdk.api.response;

import com.letv.common.sdk.api.LetvObject;
import java.util.Date;

/**
 * UserJidResponse：返回对象<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class UserJidResponse implements LetvObject {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /**  */
    private Long jidId; 
    /**  */
    private String jidSha; 
    /**  */
    private String jid; 
    /**  */
    private Integer historyEnabled; 
    
    public Long getJidId(){
        return jidId;
    }
        
    public void setJidId(Long jidId) {
        this.jidId = jidId;
    }
    
    public String getJidSha(){
        return jidSha;
    }
        
    public void setJidSha(String jidSha) {
        this.jidSha = jidSha;
    }
    
    public String getJid(){
        return jid;
    }
        
    public void setJid(String jid) {
        this.jid = jid;
    }
    
    public Integer getHistoryEnabled(){
        return historyEnabled;
    }
        
    public void setHistoryEnabled(Integer historyEnabled) {
        this.historyEnabled = historyEnabled;
    }
}
