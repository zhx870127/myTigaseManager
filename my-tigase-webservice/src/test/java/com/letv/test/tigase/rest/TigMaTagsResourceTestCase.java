package com.letv.test.tigase.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.letv.common.client.AbstractClient;
import com.letv.test.tigase.rest.dto.TigMaTags;
import com.letv.test.tigase.rest.request.TigMaTagsRequest;
import com.letv.test.tigase.rest.response.TigMaTagsResponse;
import com.letv.test.tigase.rest.Urls;

/**
 * TigMaTagsResource单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class TigMaTagsResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetTigMaTags() {
        String url= Urls.API_DOMAIN + "/tigMaTags/getTigMaTags";

        TigMaTagsRequest request = new TigMaTagsRequest();
        request.setId(1l);
        TigMaTagsResponse response = super.getRestTemplate().postForObject(url, request, TigMaTagsResponse.class);
        Assert.notNull(response);
        TigMaTags tigMaTags = super.getResult(response);
        Assert.notNull(tigMaTags);
    }
}
