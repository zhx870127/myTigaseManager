package com.letv.test.tigase.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.letv.common.client.AbstractClient;
import com.letv.test.tigase.rest.dto.TigSocks5Connections;
import com.letv.test.tigase.rest.request.TigSocks5ConnectionsRequest;
import com.letv.test.tigase.rest.response.TigSocks5ConnectionsResponse;
import com.letv.test.tigase.rest.Urls;

/**
 * TigSocks5ConnectionsResource单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class TigSocks5ConnectionsResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetTigSocks5Connections() {
        String url= Urls.API_DOMAIN + "/tigSocks5Connections/getTigSocks5Connections";

        TigSocks5ConnectionsRequest request = new TigSocks5ConnectionsRequest();
        request.setId(1l);
        TigSocks5ConnectionsResponse response = super.getRestTemplate().postForObject(url, request, TigSocks5ConnectionsResponse.class);
        Assert.notNull(response);
        TigSocks5Connections tigSocks5Connections = super.getResult(response);
        Assert.notNull(tigSocks5Connections);
    }
}
