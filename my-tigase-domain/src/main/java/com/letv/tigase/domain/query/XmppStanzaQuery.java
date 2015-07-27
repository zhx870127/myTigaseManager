package com.letv.tigase.domain.query;

import java.util.Date;

import com.letv.common.utils.page.Query;

/**
 * XmppStanzaQuery：查询类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class XmppStanzaQuery extends Query {
    
    /**  */
	private Long id; 
    /**  */
	private String stanza; 
    /** 开始时间 */
    private Date startTime; 
    /** 结束时间 */
    private Date endTime; 
	
    public Long getId(){
		return id;
	}
	    
    public void setId(Long id) {
		this.id = id;
	}
	
    public String getStanza(){
		return stanza;
	}
	    
    public void setStanza(String stanza) {
		this.stanza = stanza;
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
