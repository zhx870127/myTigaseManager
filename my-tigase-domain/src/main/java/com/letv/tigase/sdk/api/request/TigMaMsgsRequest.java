package com.letv.tigase.sdk.api.request;

import com.letv.common.sdk.api.request.LetvRequest;
import java.util.Date;

/**
 * TigMaMsgsRequest：请求参数
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class TigMaMsgsRequest extends LetvRequest {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /**  */
    private Long msgId; 
    /**  */
    private Long ownerId; 
    /**  */
    private Long buddyId; 
    /**  */
    private Date ts; 
    /**  */
    private Integer direction; 
    /**  */
    private String type; 
    /**  */
    private String body; 
    /**  */
    private String msg; 
    
    public Long getMsgId(){
        return msgId;
    }
        
    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }
    
    public Long getOwnerId(){
        return ownerId;
    }
        
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
    
    public Long getBuddyId(){
        return buddyId;
    }
        
    public void setBuddyId(Long buddyId) {
        this.buddyId = buddyId;
    }
    
    public Date getTs(){
        return ts;
    }
        
    public void setTs(Date ts) {
        this.ts = ts;
    }
    
    public Integer getDirection(){
        return direction;
    }
        
    public void setDirection(Integer direction) {
        this.direction = direction;
    }
    
    public String getType(){
        return type;
    }
        
    public void setType(String type) {
        this.type = type;
    }
    
    public String getBody(){
        return body;
    }
        
    public void setBody(String body) {
        this.body = body;
    }
    
    public String getMsg(){
        return msg;
    }
        
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
