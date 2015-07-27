package com.letv.test.tigase.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.letv.common.client.AbstractClient;
import com.letv.test.tigase.rest.dto.TigMaJids;
import com.letv.test.tigase.rest.request.TigMaJidsRequest;
import com.letv.test.tigase.rest.response.TigMaJidsResponse;
import com.letv.test.tigase.rest.Urls;

/**
 * TigMaJidsResource单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class TigMaJidsResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetTigMaJids() {
        String url= Urls.API_DOMAIN + "/tigMaJids/getTigMaJids";

        TigMaJidsRequest request = new TigMaJidsRequest();
        request.setId(1l);
        TigMaJidsResponse response = super.getRestTemplate().postForObject(url, request, TigMaJidsResponse.class);
        Assert.notNull(response);
        TigMaJids tigMaJids = super.getResult(response);
        Assert.notNull(tigMaJids);
    }
}
