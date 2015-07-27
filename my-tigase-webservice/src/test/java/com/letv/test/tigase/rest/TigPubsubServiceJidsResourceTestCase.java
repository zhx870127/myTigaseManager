package com.letv.test.tigase.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.letv.common.client.AbstractClient;
import com.letv.test.tigase.rest.dto.TigPubsubServiceJids;
import com.letv.test.tigase.rest.request.TigPubsubServiceJidsRequest;
import com.letv.test.tigase.rest.response.TigPubsubServiceJidsResponse;
import com.letv.test.tigase.rest.Urls;

/**
 * TigPubsubServiceJidsResource单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class TigPubsubServiceJidsResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetTigPubsubServiceJids() {
        String url= Urls.API_DOMAIN + "/tigPubsubServiceJids/getTigPubsubServiceJids";

        TigPubsubServiceJidsRequest request = new TigPubsubServiceJidsRequest();
        request.setId(1l);
        TigPubsubServiceJidsResponse response = super.getRestTemplate().postForObject(url, request, TigPubsubServiceJidsResponse.class);
        Assert.notNull(response);
        TigPubsubServiceJids tigPubsubServiceJids = super.getResult(response);
        Assert.notNull(tigPubsubServiceJids);
    }
}
