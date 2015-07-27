package com.letv.test.tigase.rest.dto;

import com.letv.common.sdk.api.LetvObject;
import java.util.Date;

/**
 * TigSocks5ConnectionsResponse：返回对象<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class TigSocks5Connections implements LetvObject {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /**  */
    private Long connId; 
    /**  */
    private Long uid; 
    /**  */
    private String instance; 
    /**  */
    private Integer direction; 
    /**  */
    private Long transferredBytes; 
    /**  */
    private Date transferTimestamp; 
    
    public Long getConnId(){
        return connId;
    }
        
    public void setConnId(Long connId) {
        this.connId = connId;
    }
    
    public Long getUid(){
        return uid;
    }
        
    public void setUid(Long uid) {
        this.uid = uid;
    }
    
    public String getInstance(){
        return instance;
    }
        
    public void setInstance(String instance) {
        this.instance = instance;
    }
    
    public Integer getDirection(){
        return direction;
    }
        
    public void setDirection(Integer direction) {
        this.direction = direction;
    }
    
    public Long getTransferredBytes(){
        return transferredBytes;
    }
        
    public void setTransferredBytes(Long transferredBytes) {
        this.transferredBytes = transferredBytes;
    }
    
    public Date getTransferTimestamp(){
        return transferTimestamp;
    }
        
    public void setTransferTimestamp(Date transferTimestamp) {
        this.transferTimestamp = transferTimestamp;
    }
}
