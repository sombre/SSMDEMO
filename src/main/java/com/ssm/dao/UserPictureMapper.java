package com.ssm.dao;

import com.ssm.model.UserPicture;
import java.util.List;

public interface UserPictureMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_picture
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long userPicId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_picture
     *
     * @mbggenerated
     */
    int insert(UserPicture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_picture
     *
     * @mbggenerated
     */
    UserPicture selectByPrimaryKey(Long userPicId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_picture
     *
     * @mbggenerated
     */
    List<UserPicture> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_picture
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserPicture record);
}