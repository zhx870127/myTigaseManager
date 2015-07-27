package com.letv.test.tigase.rest.dto;

import com.letv.common.sdk.api.LetvObject;
import java.util.Date;

/**
 * BroadcastMsgsResponse：返回对象<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class BroadcastMsgs implements LetvObject {

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
