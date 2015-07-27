package com.letv.test.tigase.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.letv.common.client.AbstractClient;
import com.letv.test.tigase.rest.dto.TigPubsubJids;
import com.letv.test.tigase.rest.request.TigPubsubJidsRequest;
import com.letv.test.tigase.rest.response.TigPubsubJidsResponse;
import com.letv.test.tigase.rest.Urls;

/**
 * TigPubsubJidsResource单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class TigPubsubJidsResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetTigPubsubJids() {
        String url= Urls.API_DOMAIN + "/tigPubsubJids/getTigPubsubJids";

        TigPubsubJidsRequest request = new TigPubsubJidsRequest();
        request.setId(1l);
        TigPubsubJidsResponse response = super.getRestTemplate().postForObject(url, request, TigPubsubJidsResponse.class);
        Assert.notNull(response);
        TigPubsubJids tigPubsubJids = super.getResult(response);
        Assert.notNull(tigPubsubJids);
    }
}
