package org.dalaoshi.multitenancydemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.dalaoshi.multitenancydemo.entity.Staff;

import java.util.List;

public interface StaffMapper extends BaseMapper<Staff> {
    List<Staff> findStaff(@Param("staffName") String staffName);
}