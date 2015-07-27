package com.letv.test.tigase.rest.dto;

import com.letv.common.sdk.api.LetvObject;
import java.util.Date;

/**
 * TigPubsubServiceJidsResponse：返回对象<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class TigPubsubServiceJids implements LetvObject {

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
