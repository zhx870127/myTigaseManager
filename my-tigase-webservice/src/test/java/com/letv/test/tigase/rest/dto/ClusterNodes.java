package com.letv.test.tigase.rest.dto;

import com.letv.common.sdk.api.LetvObject;
import java.util.Date;

/**
 * ClusterNodesResponse：返回对象<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class ClusterNodes implements LetvObject {

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
