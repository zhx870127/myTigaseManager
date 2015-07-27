package com.letv.test.tigase.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.letv.common.client.AbstractClient;
import com.letv.test.tigase.rest.dto.TigNodes;
import com.letv.test.tigase.rest.request.TigNodesRequest;
import com.letv.test.tigase.rest.response.TigNodesResponse;
import com.letv.test.tigase.rest.Urls;

/**
 * TigNodesResource单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class TigNodesResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetTigNodes() {
        String url= Urls.API_DOMAIN + "/tigNodes/getTigNodes";

        TigNodesRequest request = new TigNodesRequest();
        request.setId(1l);
        TigNodesResponse response = super.getRestTemplate().postForObject(url, request, TigNodesResponse.class);
        Assert.notNull(response);
        TigNodes tigNodes = super.getResult(response);
        Assert.notNull(tigNodes);
    }
}
