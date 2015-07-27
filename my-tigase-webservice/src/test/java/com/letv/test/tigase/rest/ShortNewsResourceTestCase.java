package com.letv.test.tigase.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.letv.common.client.AbstractClient;
import com.letv.test.tigase.rest.dto.ShortNews;
import com.letv.test.tigase.rest.request.ShortNewsRequest;
import com.letv.test.tigase.rest.response.ShortNewsResponse;
import com.letv.test.tigase.rest.Urls;

/**
 * ShortNewsResource单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class ShortNewsResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetShortNews() {
        String url= Urls.API_DOMAIN + "/shortNews/getShortNews";

        ShortNewsRequest request = new ShortNewsRequest();
        request.setId(1l);
        ShortNewsResponse response = super.getRestTemplate().postForObject(url, request, ShortNewsResponse.class);
        Assert.notNull(response);
        ShortNews shortNews = super.getResult(response);
        Assert.notNull(shortNews);
    }
}
