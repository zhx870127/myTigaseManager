package com.letv.test.tigase.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.letv.common.client.AbstractClient;
import com.letv.test.tigase.rest.dto.TigPubsubNodes;
import com.letv.test.tigase.rest.request.TigPubsubNodesRequest;
import com.letv.test.tigase.rest.response.TigPubsubNodesResponse;
import com.letv.test.tigase.rest.Urls;

/**
 * TigPubsubNodesResource单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class TigPubsubNodesResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetTigPubsubNodes() {
        String url= Urls.API_DOMAIN + "/tigPubsubNodes/getTigPubsubNodes";

        TigPubsubNodesRequest request = new TigPubsubNodesRequest();
        request.setId(1l);
        TigPubsubNodesResponse response = super.getRestTemplate().postForObject(url, request, TigPubsubNodesResponse.class);
        Assert.notNull(response);
        TigPubsubNodes tigPubsubNodes = super.getResult(response);
        Assert.notNull(tigPubsubNodes);
    }
}
