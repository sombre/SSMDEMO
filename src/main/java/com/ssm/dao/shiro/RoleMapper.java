package com.ssm.dao.shiro;

import com.ssm.model.shiro.Role;
import java.util.List;

public interface RoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbggenerated
     */
    int insert(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbggenerated
     */
    Role selectByPrimaryKey(Long roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbggenerated
     */
    List<Role> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Role record);
}