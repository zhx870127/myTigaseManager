package com.letv.tigase.domain.query;

import java.util.Date;

import com.letv.common.utils.page.Query;

/**
 * TigSocks5ConnectionsQuery：查询类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class TigSocks5ConnectionsQuery extends Query {
    
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
    /** 开始时间 */
    private Date startTime; 
    /** 结束时间 */
    private Date endTime; 
	
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

    public Date getStartTime() {
        return startTime;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    public Date getEndTime() {
        return endTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
