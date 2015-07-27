package com.letv.tigase.domain;

import com.letv.tigase.domain.base.BaseDomain;

/**
 * XmppStanza：实体类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class XmppStanza extends BaseDomain {

    /** 序列化标识 */
	private static final long serialVersionUID = 1L;
	
    /**  */
    private String stanza; 
    
    public String getStanza(){
        return stanza;
    }
        
    public void setStanza(String stanza) {
        this.stanza = stanza;
    }
}
