package com.letv.tigase.domain.query;

import java.util.Date;

import com.letv.common.utils.page.Query;

/**
 * TigPubsubNodesQuery：查询类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class TigPubsubNodesQuery extends Query {
    
    /**  */
	private Long nodeId; 
    /**  */
	private Long serviceId; 
    /**  */
	private String name; 
    /**  */
	private String nameSha1; 
    /**  */
	private Integer type; 
    /**  */
	private String title; 
    /**  */
	private String description; 
    /**  */
	private Long creatorId; 
    /**  */
	private Date creationDate; 
    /**  */
	private String configuration; 
    /**  */
	private Long collectionId; 
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
	
    public Long getServiceId(){
		return serviceId;
	}
	    
    public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	
    public String getName(){
		return name;
	}
	    
    public void setName(String name) {
		this.name = name;
	}
	
    public String getNameSha1(){
		return nameSha1;
	}
	    
    public void setNameSha1(String nameSha1) {
		this.nameSha1 = nameSha1;
	}
	
    public Integer getType(){
		return type;
	}
	    
    public void setType(Integer type) {
		this.type = type;
	}
	
    public String getTitle(){
		return title;
	}
	    
    public void setTitle(String title) {
		this.title = title;
	}
	
    public String getDescription(){
		return description;
	}
	    
    public void setDescription(String description) {
		this.description = description;
	}
	
    public Long getCreatorId(){
		return creatorId;
	}
	    
    public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	
    public Date getCreationDate(){
		return creationDate;
	}
	    
    public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
    public String getConfiguration(){
		return configuration;
	}
	    
    public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}
	
    public Long getCollectionId(){
		return collectionId;
	}
	    
    public void setCollectionId(Long collectionId) {
		this.collectionId = collectionId;
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
