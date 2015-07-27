package com.letv.tigase.domain;

import com.letv.tigase.domain.base.BaseDomain;

/**
 * TigMaTags：实体类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class TigMaTags extends BaseDomain {

    /** 序列化标识 */
	private static final long serialVersionUID = 1L;
	
    /**  */
    private Long tagId; 
    /**  */
    private String tag; 
    /**  */
    private Long ownerId; 
    
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
}
