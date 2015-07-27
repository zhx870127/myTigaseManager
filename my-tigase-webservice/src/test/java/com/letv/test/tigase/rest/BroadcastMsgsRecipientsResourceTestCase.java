package com.letv.test.tigase.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.letv.common.client.AbstractClient;
import com.letv.test.tigase.rest.dto.BroadcastMsgsRecipients;
import com.letv.test.tigase.rest.request.BroadcastMsgsRecipientsRequest;
import com.letv.test.tigase.rest.response.BroadcastMsgsRecipientsResponse;
import com.letv.test.tigase.rest.Urls;

/**
 * BroadcastMsgsRecipientsResource单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class BroadcastMsgsRecipientsResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetBroadcastMsgsRecipients() {
        String url= Urls.API_DOMAIN + "/broadcastMsgsRecipients/getBroadcastMsgsRecipients";

        BroadcastMsgsRecipientsRequest request = new BroadcastMsgsRecipientsRequest();
        request.setId(1l);
        BroadcastMsgsRecipientsResponse response = super.getRestTemplate().postForObject(url, request, BroadcastMsgsRecipientsResponse.class);
        Assert.notNull(response);
        BroadcastMsgsRecipients broadcastMsgsRecipients = super.getResult(response);
        Assert.notNull(broadcastMsgsRecipients);
    }
}
