package com.letv.test.tigase.rest.dto;

import com.letv.common.sdk.api.LetvObject;
import java.util.Date;

/**
 * MsgHistoryResponse：返回对象<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class MsgHistory implements LetvObject {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /**  */
    private Long msgId; 
    /**  */
    private Date ts; 
    /**  */
    private Date expired; 
    /**  */
    private Long senderUid; 
    /**  */
    private Long receiverUid; 
    /**  */
    private Integer msgType; 
    /**  */
    private String message; 
    
    public Long getMsgId(){
        return msgId;
    }
        
    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }
    
    public Date getTs(){
        return ts;
    }
        
    public void setTs(Date ts) {
        this.ts = ts;
    }
    
    public Date getExpired(){
        return expired;
    }
        
    public void setExpired(Date expired) {
        this.expired = expired;
    }
    
    public Long getSenderUid(){
        return senderUid;
    }
        
    public void setSenderUid(Long senderUid) {
        this.senderUid = senderUid;
    }
    
    public Long getReceiverUid(){
        return receiverUid;
    }
        
    public void setReceiverUid(Long receiverUid) {
        this.receiverUid = receiverUid;
    }
    
    public Integer getMsgType(){
        return msgType;
    }
        
    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }
    
    public String getMessage(){
        return message;
    }
        
    public void setMessage(String message) {
        this.message = message;
    }
}
