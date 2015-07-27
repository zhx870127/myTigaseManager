package com.letv.tigase.domain;

import com.letv.tigase.domain.base.BaseDomain;

/**
 * BroadcastMsgsRecipients：实体类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class BroadcastMsgsRecipients extends BaseDomain {

    /** 序列化标识 */
	private static final long serialVersionUID = 1L;
	
    /**  */
    private String msgId; 
    /**  */
    private Long jidId; 
    
    public String getMsgId(){
        return msgId;
    }
        
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
    
    public Long getJidId(){
        return jidId;
    }
        
    public void setJidId(Long jidId) {
        this.jidId = jidId;
    }
}
