package com.letv.test.tigase.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.letv.common.client.AbstractClient;
import com.letv.test.tigase.rest.dto.TigMaMsgs;
import com.letv.test.tigase.rest.request.TigMaMsgsRequest;
import com.letv.test.tigase.rest.response.TigMaMsgsResponse;
import com.letv.test.tigase.rest.Urls;

/**
 * TigMaMsgsResource单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class TigMaMsgsResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetTigMaMsgs() {
        String url= Urls.API_DOMAIN + "/tigMaMsgs/getTigMaMsgs";

        TigMaMsgsRequest request = new TigMaMsgsRequest();
        request.setId(1l);
        TigMaMsgsResponse response = super.getRestTemplate().postForObject(url, request, TigMaMsgsResponse.class);
        Assert.notNull(response);
        TigMaMsgs tigMaMsgs = super.getResult(response);
        Assert.notNull(tigMaMsgs);
    }
}
