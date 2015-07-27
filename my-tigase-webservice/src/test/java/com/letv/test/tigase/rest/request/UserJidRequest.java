package com.letv.test.tigase.rest.request;

import com.letv.common.sdk.api.request.LetvRequest;
import java.util.Date;

/**
 * UserJidRequest：请求参数
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class UserJidRequest extends LetvRequest {

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
