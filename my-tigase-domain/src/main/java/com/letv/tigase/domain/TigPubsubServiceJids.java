package com.letv.tigase.domain;

import com.letv.tigase.domain.base.BaseDomain;

/**
 * TigPubsubServiceJids：实体类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class TigPubsubServiceJids extends BaseDomain {

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
