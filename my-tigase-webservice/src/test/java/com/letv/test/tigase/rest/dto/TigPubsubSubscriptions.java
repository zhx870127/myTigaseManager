package com.letv.test.tigase.rest.dto;

import com.letv.common.sdk.api.LetvObject;
import java.util.Date;

/**
 * TigPubsubSubscriptionsResponse：返回对象<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class TigPubsubSubscriptions implements LetvObject {

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
