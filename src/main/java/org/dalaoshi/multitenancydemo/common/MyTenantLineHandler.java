package org.dalaoshi.multitenancydemo.common;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;

/*
 *功能描述 ：租户拦截器 MyTenantLineHandler 代码。实现 mybatis 自带的租户 Handler，
 * 实现 getTenantId() 方法，mybatis 执行sql 时会通过此方法将得到的租户id条件插入到sql里。
 * @author dalaoshi
 */
public class MyTenantLineHandler implements TenantLineHandler {
    //从租户上下文中取出当前租户id
    @Override
    public Expression getTenantId() {
        return new StringValue(TenantContext.getCurrentTenant());
    }
    //匹配数据库的列名
    @Override
    public String getTenantIdColumn() {
        //这里对应的是数据库的列名
        return "tenant_id";
    }
    @Override
    public boolean ignoreTable(String tableName) {
        //如果那些表不需要做租户隔离的，在这里配置
        return false;
    }
}