package com.letv.tigase.domain.query;

import java.util.Date;

import com.letv.common.utils.page.Query;

/**
 * TigPubsubItemsQuery：查询类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class TigPubsubItemsQuery extends Query {
    
    /**  */
	private Long nodeId; 
    /**  */
	private String id; 
    /**  */
	private String idSha1; 
    /**  */
	private Date creationDate; 
    /**  */
	private Long publisherId; 
    /**  */
	private Date updateDate; 
    /**  */
	private String data; 
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
	
    public String getId(){
		return id;
	}
	    
    public void setId(String id) {
		this.id = id;
	}
	
    public String getIdSha1(){
		return idSha1;
	}
	    
    public void setIdSha1(String idSha1) {
		this.idSha1 = idSha1;
	}
	
    public Date getCreationDate(){
		return creationDate;
	}
	    
    public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
    public Long getPublisherId(){
		return publisherId;
	}
	    
    public void setPublisherId(Long publisherId) {
		this.publisherId = publisherId;
	}
	
    public Date getUpdateDate(){
		return updateDate;
	}
	    
    public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
    public String getData(){
		return data;
	}
	    
    public void setData(String data) {
		this.data = data;
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
