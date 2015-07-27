package com.letv.tigase.domain.query;

import java.util.Date;

import com.letv.common.utils.page.Query;

/**
 * TigMaTagsQuery：查询类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class TigMaTagsQuery extends Query {
    
    /**  */
	private Long tagId; 
    /**  */
	private String tag; 
    /**  */
	private Long ownerId; 
    /** 开始时间 */
    private Date startTime; 
    /** 结束时间 */
    private Date endTime; 
	
    public Long getTagId(){
		return tagId;
	}
	    
    public void setTagId(Long tagId) {
		this.tagId = tagId;
	}
	
    public String getTag(){
		return tag;
	}
	    
    public void setTag(String tag) {
		this.tag = tag;
	}
	
    public Long getOwnerId(){
		return ownerId;
	}
	    
    public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
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
