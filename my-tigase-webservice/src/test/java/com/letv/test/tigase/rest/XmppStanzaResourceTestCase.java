package com.letv.test.tigase.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.letv.common.client.AbstractClient;
import com.letv.test.tigase.rest.dto.XmppStanza;
import com.letv.test.tigase.rest.request.XmppStanzaRequest;
import com.letv.test.tigase.rest.response.XmppStanzaResponse;
import com.letv.test.tigase.rest.Urls;

/**
 * XmppStanzaResource单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class XmppStanzaResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetXmppStanza() {
        String url= Urls.API_DOMAIN + "/xmppStanza/getXmppStanza";

        XmppStanzaRequest request = new XmppStanzaRequest();
        request.setId(1l);
        XmppStanzaResponse response = super.getRestTemplate().postForObject(url, request, XmppStanzaResponse.class);
        Assert.notNull(response);
        XmppStanza xmppStanza = super.getResult(response);
        Assert.notNull(xmppStanza);
    }
}
