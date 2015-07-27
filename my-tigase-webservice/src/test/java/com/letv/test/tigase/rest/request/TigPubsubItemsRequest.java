package com.letv.test.tigase.rest.request;

import com.letv.common.sdk.api.request.LetvRequest;
import java.util.Date;

/**
 * TigPubsubItemsRequest：请求参数
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class TigPubsubItemsRequest extends LetvRequest {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
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
}
