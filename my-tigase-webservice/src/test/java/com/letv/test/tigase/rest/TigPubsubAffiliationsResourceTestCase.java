package com.letv.test.tigase.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.letv.common.client.AbstractClient;
import com.letv.test.tigase.rest.dto.TigPubsubAffiliations;
import com.letv.test.tigase.rest.request.TigPubsubAffiliationsRequest;
import com.letv.test.tigase.rest.response.TigPubsubAffiliationsResponse;
import com.letv.test.tigase.rest.Urls;

/**
 * TigPubsubAffiliationsResource单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class TigPubsubAffiliationsResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetTigPubsubAffiliations() {
        String url= Urls.API_DOMAIN + "/tigPubsubAffiliations/getTigPubsubAffiliations";

        TigPubsubAffiliationsRequest request = new TigPubsubAffiliationsRequest();
        request.setId(1l);
        TigPubsubAffiliationsResponse response = super.getRestTemplate().postForObject(url, request, TigPubsubAffiliationsResponse.class);
        Assert.notNull(response);
        TigPubsubAffiliations tigPubsubAffiliations = super.getResult(response);
        Assert.notNull(tigPubsubAffiliations);
    }
}
