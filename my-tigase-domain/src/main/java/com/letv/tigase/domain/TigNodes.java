package com.letv.tigase.domain;

import com.letv.tigase.domain.base.BaseDomain;

/**
 * TigNodes：实体类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class TigNodes extends BaseDomain {

    /** 序列化标识 */
	private static final long serialVersionUID = 1L;
	
    /**  */
    private Long nid; 
    /**  */
    private Long parentNid; 
    /**  */
    private Long uid; 
    /**  */
    private String node; 
    
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
}
