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
import com.letv.tigase.domain.XmppStanza;
import com.letv.tigase.sdk.api.request.XmppStanzaRequest;
import com.letv.tigase.sdk.api.response.XmppStanzaResponse;
import com.letv.tigase.service.XmppStanzaService;

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
public class XmppStanzaResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private XmppStanzaService xmppStanzaService; 

    /**
     * 查询信息
     * 
     * @param request
     *            请求参数
     * @return 返回对象
     * 
     */
    @POST
    @Path("/xmppStanza/getXmppStanza")
    public Wrapper<?> getXmppStanza(XmppStanzaRequest request) {
        if (null == request || null == request.getId()) {
            this.logger.error("getXmppStanza 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            XmppStanza xmppStanza = xmppStanzaService.getXmppStanzaById(request.getId());
            XmppStanzaResponse response = convert(xmppStanza);
            return WrapMapper.ok().result(response);
        } catch (Exception e) {
            this.logger.error("查询数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private XmppStanzaResponse convert(XmppStanza xmppStanza) {
        if (null == xmppStanza) {
            return null;
        }

        XmppStanzaResponse xmppStanzaResponse = new XmppStanzaResponse();
        BeanUtils.copyProperties(xmppStanza, xmppStanzaResponse);
        return xmppStanzaResponse;
    }

    // 数据转换
    private List<XmppStanzaResponse> convertList(List<XmppStanza> xmppStanzas) {
        if (CollectionUtils.isEmpty(xmppStanzas)) {
            return null;
        }

        List<XmppStanzaResponse> list = new ArrayList<XmppStanzaResponse>(xmppStanzas.size());
        for (XmppStanza xmppStanza : xmppStanzas) {
            list.add(convert(xmppStanza));
        }
        return list;
    } 

}
