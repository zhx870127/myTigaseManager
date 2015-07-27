package com.letv.test.tigase.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.letv.common.client.AbstractClient;
import com.letv.test.tigase.rest.dto.MsgHistory;
import com.letv.test.tigase.rest.request.MsgHistoryRequest;
import com.letv.test.tigase.rest.response.MsgHistoryResponse;
import com.letv.test.tigase.rest.Urls;

/**
 * MsgHistoryResource单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class MsgHistoryResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetMsgHistory() {
        String url= Urls.API_DOMAIN + "/msgHistory/getMsgHistory";

        MsgHistoryRequest request = new MsgHistoryRequest();
        request.setId(1l);
        MsgHistoryResponse response = super.getRestTemplate().postForObject(url, request, MsgHistoryResponse.class);
        Assert.notNull(response);
        MsgHistory msgHistory = super.getResult(response);
        Assert.notNull(msgHistory);
    }
}
