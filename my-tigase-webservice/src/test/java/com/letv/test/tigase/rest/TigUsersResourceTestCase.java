package com.letv.test.tigase.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.letv.common.client.AbstractClient;
import com.letv.test.tigase.rest.dto.TigUsers;
import com.letv.test.tigase.rest.request.TigUsersRequest;
import com.letv.test.tigase.rest.response.TigUsersResponse;
import com.letv.test.tigase.rest.Urls;

/**
 * TigUsersResource单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class TigUsersResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetTigUsers() {
        String url= Urls.API_DOMAIN + "/tigUsers/getTigUsers";

        TigUsersRequest request = new TigUsersRequest();
        request.setId(1l);
        TigUsersResponse response = super.getRestTemplate().postForObject(url, request, TigUsersResponse.class);
        Assert.notNull(response);
        TigUsers tigUsers = super.getResult(response);
        Assert.notNull(tigUsers);
    }
}
