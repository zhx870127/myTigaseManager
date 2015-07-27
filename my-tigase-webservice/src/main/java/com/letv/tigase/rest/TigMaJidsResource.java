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
import com.letv.tigase.domain.TigMaJids;
import com.letv.tigase.sdk.api.request.TigMaJidsRequest;
import com.letv.tigase.sdk.api.response.TigMaJidsResponse;
import com.letv.tigase.service.TigMaJidsService;

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
public class TigMaJidsResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private TigMaJidsService tigMaJidsService; 

    /**
     * 查询信息
     * 
     * @param request
     *            请求参数
     * @return 返回对象
     * 
     */
    @POST
    @Path("/tigMaJids/getTigMaJids")
    public Wrapper<?> getTigMaJids(TigMaJidsRequest request) {
        if (null == request || null == request.getJidId()) {
            this.logger.error("getTigMaJids 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            TigMaJids tigMaJids = tigMaJidsService.getTigMaJidsById(request.getJidId());
            TigMaJidsResponse response = convert(tigMaJids);
            return WrapMapper.ok().result(response);
        } catch (Exception e) {
            this.logger.error("查询数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private TigMaJidsResponse convert(TigMaJids tigMaJids) {
        if (null == tigMaJids) {
            return null;
        }

        TigMaJidsResponse tigMaJidsResponse = new TigMaJidsResponse();
        BeanUtils.copyProperties(tigMaJids, tigMaJidsResponse);
        return tigMaJidsResponse;
    }

    // 数据转换
    private List<TigMaJidsResponse> convertList(List<TigMaJids> tigMaJidss) {
        if (CollectionUtils.isEmpty(tigMaJidss)) {
            return null;
        }

        List<TigMaJidsResponse> list = new ArrayList<TigMaJidsResponse>(tigMaJidss.size());
        for (TigMaJids tigMaJids : tigMaJidss) {
            list.add(convert(tigMaJids));
        }
        return list;
    } 

}
