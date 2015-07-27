package com.letv.tigase.domain.query;

import java.util.Date;

import com.letv.common.utils.page.Query;

/**
 * TigPubsubAffiliationsQuery：查询类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class TigPubsubAffiliationsQuery extends Query {
    
    /**  */
	private Long nodeId; 
    /**  */
	private Long jidId; 
    /**  */
	private String affiliation; 
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
	
    public String getAffiliation(){
		return affiliation;
	}
	    
    public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
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
