package com.letv.tigase.domain;

import com.letv.tigase.domain.base.BaseDomain;

/**
 * BroadcastMsgs：实体类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class BroadcastMsgs extends BaseDomain {

    /** 序列化标识 */
	private static final long serialVersionUID = 1L;
	
    /**  */
    private Date expired; 
    /**  */
    private String msg; 
    
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
