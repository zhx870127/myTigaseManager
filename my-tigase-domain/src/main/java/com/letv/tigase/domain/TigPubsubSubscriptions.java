package com.letv.tigase.domain;

import com.letv.tigase.domain.base.BaseDomain;

/**
 * TigPubsubSubscriptions：实体类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class TigPubsubSubscriptions extends BaseDomain {

    /** 序列化标识 */
	private static final long serialVersionUID = 1L;
	
    /**  */
    private Long nodeId; 
    /**  */
    private Long jidId; 
    /**  */
    private String subscription; 
    /**  */
    private String subscriptionId; 
    
    public Long getNodeId(){
        return nodeId;
    }
        
    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }
    
    public Long getJidId(){
        return jidId;
    }
        
    public void setJidId(Long jidId) {
        this.jidId = jidId;
    }
    
    public String getSubscription(){
        return subscription;
    }
        
    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }
    
    public String getSubscriptionId(){
        return subscriptionId;
    }
        
    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
}
