package com.letv.tigase.sdk.api.request;

import com.letv.common.sdk.api.request.LetvRequest;
import java.util.Date;

/**
 * ShortNewsRequest：请求参数
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:58
 * 
 */
public class ShortNewsRequest extends LetvRequest {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
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
}
