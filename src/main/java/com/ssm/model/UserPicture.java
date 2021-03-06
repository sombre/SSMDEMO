package com.ssm.model;

import java.io.Serializable;

public class UserPicture implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_picture.user_pic_Id
     *
     * @mbggenerated
     */
    private Long userPicId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_picture.user_id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_picture.picture_id
     *
     * @mbggenerated
     */
    private Long pictureId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_picture
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_picture.user_pic_Id
     *
     * @return the value of user_picture.user_pic_Id
     *
     * @mbggenerated
     */
    public Long getUserPicId() {
        return userPicId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_picture.user_pic_Id
     *
     * @param userPicId the value for user_picture.user_pic_Id
     *
     * @mbggenerated
     */
    public void setUserPicId(Long userPicId) {
        this.userPicId = userPicId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_picture.user_id
     *
     * @return the value of user_picture.user_id
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_picture.user_id
     *
     * @param userId the value for user_picture.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_picture.picture_id
     *
     * @return the value of user_picture.picture_id
     *
     * @mbggenerated
     */
    public Long getPictureId() {
        return pictureId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_picture.picture_id
     *
     * @param pictureId the value for user_picture.picture_id
     *
     * @mbggenerated
     */
    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_picture
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserPicture other = (UserPicture) that;
        return (this.getUserPicId() == null ? other.getUserPicId() == null : this.getUserPicId().equals(other.getUserPicId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPictureId() == null ? other.getPictureId() == null : this.getPictureId().equals(other.getPictureId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_picture
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserPicId() == null) ? 0 : getUserPicId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPictureId() == null) ? 0 : getPictureId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_picture
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userPicId=").append(userPicId);
        sb.append(", userId=").append(userId);
        sb.append(", pictureId=").append(pictureId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}