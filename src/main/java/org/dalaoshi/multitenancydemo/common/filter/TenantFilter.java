package org.dalaoshi.multitenancydemo.common.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.dalaoshi.multitenancydemo.common.TenantContext;
import org.springframework.core.annotation.Order;

import java.io.IOException;

/*
 *功能描述 配置过滤器，过滤器负责将请求头传过来的租户id放入租户上下文。
 * @author dalaoshi
 */
@Order(1)
public class TenantFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        TenantContext.setCurrentTenant(getHeaderOrParam(servletRequest));
        filterChain.doFilter(servletRequest, servletResponse);
    }
    private String getHeaderOrParam(ServletRequest request) {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        return httpRequest.getHeader("tenant_id");
    }
}