package com.letv.test.tigase.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.letv.common.client.AbstractClient;
import com.letv.test.tigase.rest.dto.ClusterNodes;
import com.letv.test.tigase.rest.request.ClusterNodesRequest;
import com.letv.test.tigase.rest.response.ClusterNodesResponse;
import com.letv.test.tigase.rest.Urls;

/**
 * ClusterNodesResource单元测试
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:02
 * 
 */
public class ClusterNodesResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetClusterNodes() {
        String url= Urls.API_DOMAIN + "/clusterNodes/getClusterNodes";

        ClusterNodesRequest request = new ClusterNodesRequest();
        request.setId(1l);
        ClusterNodesResponse response = super.getRestTemplate().postForObject(url, request, ClusterNodesResponse.class);
        Assert.notNull(response);
        ClusterNodes clusterNodes = super.getResult(response);
        Assert.notNull(clusterNodes);
    }
}
