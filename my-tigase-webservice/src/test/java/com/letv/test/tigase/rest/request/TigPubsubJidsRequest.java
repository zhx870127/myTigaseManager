package com.letv.test.tigase.rest.request;

import com.letv.common.sdk.api.request.LetvRequest;
import java.util.Date;

/**
 * TigPubsubJidsRequest：请求参数
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class TigPubsubJidsRequest extends LetvRequest {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /**  */
    private Long jidId; 
    /**  */
    private String jid; 
    /**  */
    private String jidSha1; 
    
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
    
    public String getJidSha1(){
        return jidSha1;
    }
        
    public void setJidSha1(String jidSha1) {
        this.jidSha1 = jidSha1;
    }
}
