package com.letv.test.tigase.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.letv.common.client.AbstractClient;
import com.letv.test.tigase.rest.dto.BroadcastMsgs;
import com.letv.test.tigase.rest.request.BroadcastMsgsRequest;
import com.letv.test.tigase.rest.response.BroadcastMsgsResponse;
import com.letv.test.tigase.rest.Urls;

/**
 * BroadcastMsgsResource单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class BroadcastMsgsResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetBroadcastMsgs() {
        String url= Urls.API_DOMAIN + "/broadcastMsgs/getBroadcastMsgs";

        BroadcastMsgsRequest request = new BroadcastMsgsRequest();
        request.setId(1l);
        BroadcastMsgsResponse response = super.getRestTemplate().postForObject(url, request, BroadcastMsgsResponse.class);
        Assert.notNull(response);
        BroadcastMsgs broadcastMsgs = super.getResult(response);
        Assert.notNull(broadcastMsgs);
    }
}
