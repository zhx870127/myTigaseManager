package com.letv.tigase.domain;

import com.letv.tigase.domain.base.BaseDomain;

/**
 * UserJid：实体类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class UserJid extends BaseDomain {

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
