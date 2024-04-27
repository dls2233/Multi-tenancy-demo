package org.dalaoshi.multitenancydemo.common;

/*
 *功能描述 租户上下文的实现：通过threadLocal 用于存储当前租户的Id
 * @author dalaoshi
 */
public class TenantContext {
    private static String tenantId = null;

    private static final ThreadLocal<String> currentTenant = new InheritableThreadLocal<>();

    public static String getCurrentTenant() {
        return currentTenant.get();
    }

    public static void setCurrentTenant(String tenantId) {
        currentTenant.set(tenantId);
    }

    public static void clear() {
        currentTenant.remove();
    }
}