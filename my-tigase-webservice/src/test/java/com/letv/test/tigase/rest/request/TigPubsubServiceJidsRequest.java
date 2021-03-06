package com.letv.test.tigase.rest.request;

import com.letv.common.sdk.api.request.LetvRequest;
import java.util.Date;

/**
 * TigPubsubServiceJidsRequest：请求参数
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class TigPubsubServiceJidsRequest extends LetvRequest {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /**  */
    private Long serviceId; 
    /**  */
    private String serviceJid; 
    /**  */
    private String serviceJidSha1; 
    
    public Long getServiceId(){
        return serviceId;
    }
        
    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
    
    public String getServiceJid(){
        return serviceJid;
    }
        
    public void setServiceJid(String serviceJid) {
        this.serviceJid = serviceJid;
    }
    
    public String getServiceJidSha1(){
        return serviceJidSha1;
    }
        
    public void setServiceJidSha1(String serviceJidSha1) {
        this.serviceJidSha1 = serviceJidSha1;
    }
}
