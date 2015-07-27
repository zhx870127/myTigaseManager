package com.letv.tigase.domain.base;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.letv.common.utils.serialize.CustomerDateSerializer;

/**
 * AbstractDomain实体类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public abstract class AbstractDomain implements java.io.Serializable {

    /** 序列化标识 */
	private static final long serialVersionUID = 1L;

    /** 创建人 */
    private String createUser; 
    /** 创建时间 */
    private Date createTime; 
    /** 修改人 */
    private String updateUser; 
    /** 修改时间 */
    private Date updateTime; 
    /** 是否有效  0：无效，1：有效 */
    private Integer yn; 
    
    public String getCreateUser(){
        return createUser;
    }
        
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    
    public Date getCreateTime(){
        return createTime;
    }
        
    @JsonSerialize(using = CustomerDateSerializer.class)  
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public String getUpdateUser(){
        return updateUser;
    }
        
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    
    @JsonSerialize(using = CustomerDateSerializer.class)  
    public Date getUpdateTime(){
        return updateTime;
    }
        
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public Integer getYn(){
        return yn;
    }
        
    public void setYn(Integer yn) {
        this.yn = yn;
    }
}
