package com.letv.test.tigase.rest.dto;

import com.letv.common.sdk.api.LetvObject;
import java.util.Date;

/**
 * BroadcastMsgsRecipientsResponse：返回对象<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class BroadcastMsgsRecipients implements LetvObject {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /**  */
    private String msgId; 
    /**  */
    private Long jidId; 
    
    public String getMsgId(){
        return msgId;
    }
        
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
    
    public Long getJidId(){
        return jidId;
    }
        
    public void setJidId(Long jidId) {
        this.jidId = jidId;
    }
}
