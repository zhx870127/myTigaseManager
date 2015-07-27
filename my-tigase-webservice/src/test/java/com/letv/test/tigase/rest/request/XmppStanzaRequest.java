package com.letv.test.tigase.rest.request;

import com.letv.common.sdk.api.request.LetvRequest;
import java.util.Date;

/**
 * XmppStanzaRequest：请求参数
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class XmppStanzaRequest extends LetvRequest {

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
