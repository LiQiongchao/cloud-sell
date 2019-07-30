package com.chaox.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 买家权限过滤
 * @Author: LiQiongchao
 * @Date: 2019/7/24 23:32
 */
@Component
public class BuyerFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SERVLET_DETECTION_FILTER_ORDER - 2;
    }

    @Override
    public boolean shouldFilter() {

        /**
         * 是否使用该filter，true：应用，false：不应用
         *
         * 读取redis判断要对哪些URI进行过滤，不需要验证权限的url直接放行
         */
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String requestURI = request.getRequestURI();
        if (requestURI.equalsIgnoreCase("")) {
            // 验证URI
            return false;
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        /**
         * 在这里验证用户是否用访问权限
         */
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        if (StringUtils.isBlank(request.getParameter("openid"))) {
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
    }
}
