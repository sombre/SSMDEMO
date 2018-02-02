package com.ssm.model.shiro;

import java.io.Serializable;

public class GroupUser implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column group_user.group_usr_id
     *
     * @mbggenerated
     */
    private Long groupUsrId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column group_user.groupid
     *
     * @mbggenerated
     */
    private Long groupid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column group_user.uid
     *
     * @mbggenerated
     */
    private Long uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table group_user
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column group_user.group_usr_id
     *
     * @return the value of group_user.group_usr_id
     *
     * @mbggenerated
     */
    public Long getGroupUsrId() {
        return groupUsrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column group_user.group_usr_id
     *
     * @param groupUsrId the value for group_user.group_usr_id
     *
     * @mbggenerated
     */
    public void setGroupUsrId(Long groupUsrId) {
        this.groupUsrId = groupUsrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column group_user.groupid
     *
     * @return the value of group_user.groupid
     *
     * @mbggenerated
     */
    public Long getGroupid() {
        return groupid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column group_user.groupid
     *
     * @param groupid the value for group_user.groupid
     *
     * @mbggenerated
     */
    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column group_user.uid
     *
     * @return the value of group_user.uid
     *
     * @mbggenerated
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column group_user.uid
     *
     * @param uid the value for group_user.uid
     *
     * @mbggenerated
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_user
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
        GroupUser other = (GroupUser) that;
        return (this.getGroupUsrId() == null ? other.getGroupUsrId() == null : this.getGroupUsrId().equals(other.getGroupUsrId()))
            && (this.getGroupid() == null ? other.getGroupid() == null : this.getGroupid().equals(other.getGroupid()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_user
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGroupUsrId() == null) ? 0 : getGroupUsrId().hashCode());
        result = prime * result + ((getGroupid() == null) ? 0 : getGroupid().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_user
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
        sb.append(", groupid=").append(groupid);
        sb.append(", uid=").append(uid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}