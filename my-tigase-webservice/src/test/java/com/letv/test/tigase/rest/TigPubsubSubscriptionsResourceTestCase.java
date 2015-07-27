package com.letv.test.tigase.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.letv.common.client.AbstractClient;
import com.letv.test.tigase.rest.dto.TigPubsubSubscriptions;
import com.letv.test.tigase.rest.request.TigPubsubSubscriptionsRequest;
import com.letv.test.tigase.rest.response.TigPubsubSubscriptionsResponse;
import com.letv.test.tigase.rest.Urls;

/**
 * TigPubsubSubscriptionsResource单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class TigPubsubSubscriptionsResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetTigPubsubSubscriptions() {
        String url= Urls.API_DOMAIN + "/tigPubsubSubscriptions/getTigPubsubSubscriptions";

        TigPubsubSubscriptionsRequest request = new TigPubsubSubscriptionsRequest();
        request.setId(1l);
        TigPubsubSubscriptionsResponse response = super.getRestTemplate().postForObject(url, request, TigPubsubSubscriptionsResponse.class);
        Assert.notNull(response);
        TigPubsubSubscriptions tigPubsubSubscriptions = super.getResult(response);
        Assert.notNull(tigPubsubSubscriptions);
    }
}
