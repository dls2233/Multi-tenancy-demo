package org.dalaoshi.multitenancydemo.entity;

import lombok.Data;

/**
 * @author 黄一峰
 * @date 2024/4/27 16:30
 * @description Staff
 */

@Data
public class Staff {
    private Integer id;

    private String tenantId;

    private String staffId;

    private String staffName;
}
