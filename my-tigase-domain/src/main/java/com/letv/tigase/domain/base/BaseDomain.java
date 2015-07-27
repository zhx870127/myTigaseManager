package com.letv.tigase.domain.base;

import java.util.Date;

/**
 * BaseDomain实体类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public abstract class BaseDomain extends AbstractDomain {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /** 主键id */
    private Long id;
    
    public Long getId(){
        return id;
    }
        
    public void setId(Long id) {
        this.id = id;
    }
}
