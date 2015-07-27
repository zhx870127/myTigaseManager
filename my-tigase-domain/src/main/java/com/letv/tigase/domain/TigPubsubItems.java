package com.letv.tigase.domain;

import com.letv.tigase.domain.base.BaseDomain;

/**
 * TigPubsubItems：实体类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class TigPubsubItems extends BaseDomain {

    /** 序列化标识 */
	private static final long serialVersionUID = 1L;
	
    /**  */
    private Long nodeId; 
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
    
    public Long getNodeId(){
        return nodeId;
    }
        
    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
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
}
