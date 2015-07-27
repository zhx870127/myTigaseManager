package com.letv.test.tigase.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.letv.common.client.AbstractClient;
import com.letv.test.tigase.rest.dto.TigSocks5Users;
import com.letv.test.tigase.rest.request.TigSocks5UsersRequest;
import com.letv.test.tigase.rest.response.TigSocks5UsersResponse;
import com.letv.test.tigase.rest.Urls;

/**
 * TigSocks5UsersResource单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class TigSocks5UsersResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetTigSocks5Users() {
        String url= Urls.API_DOMAIN + "/tigSocks5Users/getTigSocks5Users";

        TigSocks5UsersRequest request = new TigSocks5UsersRequest();
        request.setId(1l);
        TigSocks5UsersResponse response = super.getRestTemplate().postForObject(url, request, TigSocks5UsersResponse.class);
        Assert.notNull(response);
        TigSocks5Users tigSocks5Users = super.getResult(response);
        Assert.notNull(tigSocks5Users);
    }
}
