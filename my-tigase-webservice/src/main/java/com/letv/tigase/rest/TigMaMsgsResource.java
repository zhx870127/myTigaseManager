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
import com.letv.tigase.domain.TigMaMsgs;
import com.letv.tigase.sdk.api.request.TigMaMsgsRequest;
import com.letv.tigase.sdk.api.response.TigMaMsgsResponse;
import com.letv.tigase.service.TigMaMsgsService;

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
public class TigMaMsgsResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private TigMaMsgsService tigMaMsgsService; 

    /**
     * 查询信息
     * 
     * @param request
     *            请求参数
     * @return 返回对象
     * 
     */
    @POST
    @Path("/tigMaMsgs/getTigMaMsgs")
    public Wrapper<?> getTigMaMsgs(TigMaMsgsRequest request) {
        if (null == request || null == request.getMsgId()) {
            this.logger.error("getTigMaMsgs 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            TigMaMsgs tigMaMsgs = tigMaMsgsService.getTigMaMsgsById(request.getMsgId());
            TigMaMsgsResponse response = convert(tigMaMsgs);
            return WrapMapper.ok().result(response);
        } catch (Exception e) {
            this.logger.error("查询数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private TigMaMsgsResponse convert(TigMaMsgs tigMaMsgs) {
        if (null == tigMaMsgs) {
            return null;
        }

        TigMaMsgsResponse tigMaMsgsResponse = new TigMaMsgsResponse();
        BeanUtils.copyProperties(tigMaMsgs, tigMaMsgsResponse);
        return tigMaMsgsResponse;
    }

    // 数据转换
    private List<TigMaMsgsResponse> convertList(List<TigMaMsgs> tigMaMsgss) {
        if (CollectionUtils.isEmpty(tigMaMsgss)) {
            return null;
        }

        List<TigMaMsgsResponse> list = new ArrayList<TigMaMsgsResponse>(tigMaMsgss.size());
        for (TigMaMsgs tigMaMsgs : tigMaMsgss) {
            list.add(convert(tigMaMsgs));
        }
        return list;
    } 

}
