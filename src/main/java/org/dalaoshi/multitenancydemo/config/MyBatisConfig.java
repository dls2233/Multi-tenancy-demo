package org.dalaoshi.multitenancydemo.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import org.dalaoshi.multitenancydemo.common.MyTenantLineHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
 *功能描述 配置 mybatis 拦截器，并设置租户拦截器 MyTenantLineHandler
 * @author dalaoshi
 */
@Configuration
public class MyBatisConfig {
  @Bean
  public MybatisPlusInterceptor mybatisPlusInterceptor() {
    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    // 添加租户拦截器
    interceptor.addInnerInterceptor(new TenantLineInnerInterceptor(new MyTenantLineHandler()));
    return interceptor;
  }
}