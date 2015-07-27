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
import com.letv.tigase.domain.ShortNews;
import com.letv.tigase.sdk.api.request.ShortNewsRequest;
import com.letv.tigase.sdk.api.response.ShortNewsResponse;
import com.letv.tigase.service.ShortNewsService;

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
public class ShortNewsResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private ShortNewsService shortNewsService; 

    /**
     * 查询信息
     * 
     * @param request
     *            请求参数
     * @return 返回对象
     * 
     */
    @POST
    @Path("/shortNews/getShortNews")
    public Wrapper<?> getShortNews(ShortNewsRequest request) {
        if (null == request || null == request.getSnid()) {
            this.logger.error("getShortNews 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            ShortNews shortNews = shortNewsService.getShortNewsById(request.getSnid());
            ShortNewsResponse response = convert(shortNews);
            return WrapMapper.ok().result(response);
        } catch (Exception e) {
            this.logger.error("查询数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private ShortNewsResponse convert(ShortNews shortNews) {
        if (null == shortNews) {
            return null;
        }

        ShortNewsResponse shortNewsResponse = new ShortNewsResponse();
        BeanUtils.copyProperties(shortNews, shortNewsResponse);
        return shortNewsResponse;
    }

    // 数据转换
    private List<ShortNewsResponse> convertList(List<ShortNews> shortNewss) {
        if (CollectionUtils.isEmpty(shortNewss)) {
            return null;
        }

        List<ShortNewsResponse> list = new ArrayList<ShortNewsResponse>(shortNewss.size());
        for (ShortNews shortNews : shortNewss) {
            list.add(convert(shortNews));
        }
        return list;
    } 

}
