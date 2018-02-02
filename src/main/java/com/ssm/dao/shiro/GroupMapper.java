package com.ssm.dao.shiro;

import com.ssm.model.shiro.Group;
import java.util.List;

public interface GroupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long groupid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbggenerated
     */
    int insert(Group record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbggenerated
     */
    Group selectByPrimaryKey(Long groupid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbggenerated
     */
    List<Group> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Group record);
}