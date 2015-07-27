package com.letv.tigase.domain.query;

import java.util.Date;

import com.letv.common.utils.page.Query;

/**
 * TigPubsubSubscriptionsQuery：查询类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class TigPubsubSubscriptionsQuery extends Query {
    
    /**  */
	private Long nodeId; 
    /**  */
	private Long jidId; 
    /**  */
	private String subscription; 
    /**  */
	private String subscriptionId; 
    /** 开始时间 */
    private Date startTime; 
    /** 结束时间 */
    private Date endTime; 
	
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

    public Date getStartTime() {
        return startTime;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    public Date getEndTime() {
        return endTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
