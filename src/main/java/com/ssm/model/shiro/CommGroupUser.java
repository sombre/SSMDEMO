package com.ssm.model.shiro;

import java.io.Serializable;

public class CommGroupUser implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comm_group_user.group_usr_id
     *
     * @mbggenerated
     */
    private Long groupUsrId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comm_group_user.group_id
     *
     * @mbggenerated
     */
    private Long groupId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comm_group_user.uid
     *
     * @mbggenerated
     */
    private Long uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table comm_group_user
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comm_group_user.group_usr_id
     *
     * @return the value of comm_group_user.group_usr_id
     *
     * @mbggenerated
     */
    public Long getGroupUsrId() {
        return groupUsrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comm_group_user.group_usr_id
     *
     * @param groupUsrId the value for comm_group_user.group_usr_id
     *
     * @mbggenerated
     */
    public void setGroupUsrId(Long groupUsrId) {
        this.groupUsrId = groupUsrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comm_group_user.group_id
     *
     * @return the value of comm_group_user.group_id
     *
     * @mbggenerated
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comm_group_user.group_id
     *
     * @param groupId the value for comm_group_user.group_id
     *
     * @mbggenerated
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comm_group_user.uid
     *
     * @return the value of comm_group_user.uid
     *
     * @mbggenerated
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comm_group_user.uid
     *
     * @param uid the value for comm_group_user.uid
     *
     * @mbggenerated
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comm_group_user
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
        CommGroupUser other = (CommGroupUser) that;
        return (this.getGroupUsrId() == null ? other.getGroupUsrId() == null : this.getGroupUsrId().equals(other.getGroupUsrId()))
            && (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(other.getGroupId()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comm_group_user
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGroupUsrId() == null) ? 0 : getGroupUsrId().hashCode());
        result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comm_group_user
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", groupUsrId=").append(groupUsrId);
        sb.append(", groupId=").append(groupId);
        sb.append(", uid=").append(uid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}