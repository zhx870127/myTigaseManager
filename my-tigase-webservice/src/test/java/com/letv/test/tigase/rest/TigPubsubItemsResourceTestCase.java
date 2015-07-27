package com.letv.test.tigase.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.letv.common.client.AbstractClient;
import com.letv.test.tigase.rest.dto.TigPubsubItems;
import com.letv.test.tigase.rest.request.TigPubsubItemsRequest;
import com.letv.test.tigase.rest.response.TigPubsubItemsResponse;
import com.letv.test.tigase.rest.Urls;

/**
 * TigPubsubItemsResource单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class TigPubsubItemsResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetTigPubsubItems() {
        String url= Urls.API_DOMAIN + "/tigPubsubItems/getTigPubsubItems";

        TigPubsubItemsRequest request = new TigPubsubItemsRequest();
        request.setId(1l);
        TigPubsubItemsResponse response = super.getRestTemplate().postForObject(url, request, TigPubsubItemsResponse.class);
        Assert.notNull(response);
        TigPubsubItems tigPubsubItems = super.getResult(response);
        Assert.notNull(tigPubsubItems);
    }
}
