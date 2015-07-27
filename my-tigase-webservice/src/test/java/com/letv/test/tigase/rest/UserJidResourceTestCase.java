package com.letv.test.tigase.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.letv.common.client.AbstractClient;
import com.letv.test.tigase.rest.dto.UserJid;
import com.letv.test.tigase.rest.request.UserJidRequest;
import com.letv.test.tigase.rest.response.UserJidResponse;
import com.letv.test.tigase.rest.Urls;

/**
 * UserJidResource单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class UserJidResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetUserJid() {
        String url= Urls.API_DOMAIN + "/userJid/getUserJid";

        UserJidRequest request = new UserJidRequest();
        request.setId(1l);
        UserJidResponse response = super.getRestTemplate().postForObject(url, request, UserJidResponse.class);
        Assert.notNull(response);
        UserJid userJid = super.getResult(response);
        Assert.notNull(userJid);
    }
}
