package org.dalaoshi.multitenancydemo.common.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 *功能描述 添加过滤规则
 * @author dalaoshi
 * @date 2024/4/27
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean registrationBean() {
        FilterRegistrationBean reg = new FilterRegistrationBean(new TenantFilter());
        reg.addUrlPatterns("/tenant/*");
        return reg;
    }
}