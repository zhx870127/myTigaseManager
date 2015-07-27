package com.letv.test.tigase.rest.request;

import com.letv.common.sdk.api.request.LetvRequest;
import java.util.Date;

/**
 * BroadcastMsgsRecipientsRequest：请求参数
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class BroadcastMsgsRecipientsRequest extends LetvRequest {

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
