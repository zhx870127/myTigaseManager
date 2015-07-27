package com.letv.tigase.domain.query;

import java.util.Date;

import com.letv.common.utils.page.Query;

/**
 * TigNodesQuery：查询类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class TigNodesQuery extends Query {
    
    /**  */
	private Long nid; 
    /**  */
	private Long parentNid; 
    /**  */
	private Long uid; 
    /**  */
	private String node; 
    /** 开始时间 */
    private Date startTime; 
    /** 结束时间 */
    private Date endTime; 
	
    public Long getNid(){
		return nid;
	}
	    
    public void setNid(Long nid) {
		this.nid = nid;
	}
	
    public Long getParentNid(){
		return parentNid;
	}
	    
    public void setParentNid(Long parentNid) {
		this.parentNid = parentNid;
	}
	
    public Long getUid(){
		return uid;
	}
	    
    public void setUid(Long uid) {
		this.uid = uid;
	}
	
    public String getNode(){
		return node;
	}
	    
    public void setNode(String node) {
		this.node = node;
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
