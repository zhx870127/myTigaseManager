package com.letv.tigase.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.letv.common.utils.wrap.WrapMapper;
import com.letv.common.utils.wrap.Wrapper;
import com.letv.tigase.domain.TigMaTags;
import com.letv.tigase.sdk.api.request.TigMaTagsRequest;
import com.letv.tigase.sdk.api.response.TigMaTagsResponse;
import com.letv.tigase.service.TigMaTagsService;

/**
 * REST服务：提供有关的接口
 * 
 * @author zhengxin
 * @version 2015-7-27 11:25:01
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class TigMaTagsResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private TigMaTagsService tigMaTagsService; 

    /**
     * 查询信息
     * 
     * @param request
     *            请求参数
     * @return 返回对象
     * 
     */
    @POST
    @Path("/tigMaTags/getTigMaTags")
    public Wrapper<?> getTigMaTags(TigMaTagsRequest request) {
        if (null == request || null == request.getTagId()) {
            this.logger.error("getTigMaTags 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            TigMaTags tigMaTags = tigMaTagsService.getTigMaTagsById(request.getTagId());
            TigMaTagsResponse response = convert(tigMaTags);
            return WrapMapper.ok().result(response);
        } catch (Exception e) {
            this.logger.error("查询数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private TigMaTagsResponse convert(TigMaTags tigMaTags) {
        if (null == tigMaTags) {
            return null;
        }

        TigMaTagsResponse tigMaTagsResponse = new TigMaTagsResponse();
        BeanUtils.copyProperties(tigMaTags, tigMaTagsResponse);
        return tigMaTagsResponse;
    }

    // 数据转换
    private List<TigMaTagsResponse> convertList(List<TigMaTags> tigMaTagss) {
        if (CollectionUtils.isEmpty(tigMaTagss)) {
            return null;
        }

        List<TigMaTagsResponse> list = new ArrayList<TigMaTagsResponse>(tigMaTagss.size());
        for (TigMaTags tigMaTags : tigMaTagss) {
            list.add(convert(tigMaTags));
        }
        return list;
    } 

}
