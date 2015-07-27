package com.letv.tigase.domain.query;

import java.util.Date;

import com.letv.common.utils.page.Query;

/**
 * ShortNewsQuery：查询类
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class ShortNewsQuery extends Query {
    
    /**  */
	private Long snid; 
    /**  */
	private Date publishingTime; 
    /**  */
	private String newsType; 
    /**  */
	private String author; 
    /**  */
	private String subject; 
    /**  */
	private String body; 
    /** 开始时间 */
    private Date startTime; 
    /** 结束时间 */
    private Date endTime; 
	
    public Long getSnid(){
		return snid;
	}
	    
    public void setSnid(Long snid) {
		this.snid = snid;
	}
	
    public Date getPublishingTime(){
		return publishingTime;
	}
	    
    public void setPublishingTime(Date publishingTime) {
		this.publishingTime = publishingTime;
	}
	
    public String getNewsType(){
		return newsType;
	}
	    
    public void setNewsType(String newsType) {
		this.newsType = newsType;
	}
	
    public String getAuthor(){
		return author;
	}
	    
    public void setAuthor(String author) {
		this.author = author;
	}
	
    public String getSubject(){
		return subject;
	}
	    
    public void setSubject(String subject) {
		this.subject = subject;
	}
	
    public String getBody(){
		return body;
	}
	    
    public void setBody(String body) {
		this.body = body;
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
