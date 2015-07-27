package com.letv.tigase.domain;

import com.letv.tigase.domain.base.BaseDomain;

/**
 * TigMaJids：实体类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class TigMaJids extends BaseDomain {

    /** 序列化标识 */
	private static final long serialVersionUID = 1L;
	
    /**  */
    private Long jidId; 
    /**  */
    private String jid; 
    
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
}
