package com.letv.tigase.domain.query;

import java.util.Date;

import com.letv.common.utils.page.Query;

/**
 * ClusterNodesQuery：查询类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class ClusterNodesQuery extends Query {
    
    /**  */
	private String hostname; 
    /**  */
	private String password; 
    /**  */
	private Date lastUpdate; 
    /**  */
	private Integer port; 
    /**  */
	private String cpuUsage; 
    /**  */
	private String memUsage; 
    /** 开始时间 */
    private Date startTime; 
    /** 结束时间 */
    private Date endTime; 
	
    public String getHostname(){
		return hostname;
	}
	    
    public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	
    public String getPassword(){
		return password;
	}
	    
    public void setPassword(String password) {
		this.password = password;
	}
	
    public Date getLastUpdate(){
		return lastUpdate;
	}
	    
    public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
    public Integer getPort(){
		return port;
	}
	    
    public void setPort(Integer port) {
		this.port = port;
	}
	
    public String getCpuUsage(){
		return cpuUsage;
	}
	    
    public void setCpuUsage(String cpuUsage) {
		this.cpuUsage = cpuUsage;
	}
	
    public String getMemUsage(){
		return memUsage;
	}
	    
    public void setMemUsage(String memUsage) {
		this.memUsage = memUsage;
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
