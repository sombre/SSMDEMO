package com.ssm.dao.shiro.baseshiro;

import com.ssm.model.shiro.RolePermission;
import java.util.List;

public interface RolePermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long rolePerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbggenerated
     */
    int insert(RolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbggenerated
     */
    RolePermission selectByPrimaryKey(Long rolePerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbggenerated
     */
    List<RolePermission> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(RolePermission record);
}