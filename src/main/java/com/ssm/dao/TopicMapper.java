package com.ssm.dao;

import com.ssm.model.Topic;
import java.util.List;

public interface TopicMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer tid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic
     *
     * @mbggenerated
     */
    int insert(Topic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic
     *
     * @mbggenerated
     */
    Topic selectByPrimaryKey(Integer tid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic
     *
     * @mbggenerated
     */
    List<Topic> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Topic record);
}