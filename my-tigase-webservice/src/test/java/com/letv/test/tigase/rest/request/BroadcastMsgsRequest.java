package com.letv.test.tigase.rest.request;

import com.letv.common.sdk.api.request.LetvRequest;
import java.util.Date;

/**
 * BroadcastMsgsRequest：请求参数
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class BroadcastMsgsRequest extends LetvRequest {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /**  */
    private String id; 
    /**  */
    private Date expired; 
    /**  */
    private String msg; 
    
    public String getId(){
        return id;
    }
        
    public void setId(String id) {
        this.id = id;
    }
    
    public Date getExpired(){
        return expired;
    }
        
    public void setExpired(Date expired) {
        this.expired = expired;
    }
    
    public String getMsg(){
        return msg;
    }
        
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
