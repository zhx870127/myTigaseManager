package com.letv.tigase.sdk.api.response;

import com.letv.common.sdk.api.LetvObject;
import java.util.Date;

/**
 * XmppStanzaResponse：返回对象<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class XmppStanzaResponse implements LetvObject {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /**  */
    private Long id; 
    /**  */
    private String stanza; 
    
    public Long getId(){
        return id;
    }
        
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getStanza(){
        return stanza;
    }
        
    public void setStanza(String stanza) {
        this.stanza = stanza;
    }
}
