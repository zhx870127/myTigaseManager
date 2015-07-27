package com.letv.tigase.sdk.api.request;

import com.letv.common.sdk.api.request.LetvRequest;
import java.util.Date;

/**
 * ClusterNodesRequest：请求参数
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class ClusterNodesRequest extends LetvRequest {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
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
}
