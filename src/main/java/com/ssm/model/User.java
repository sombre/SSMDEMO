package com.ssm.model;

import java.io.Serializable;

public class User implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.uid
     *
     * @mbggenerated
     */
    private Integer uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_name
     *
     * @mbggenerated
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_salt
     *
     * @mbggenerated
     */
    private String userSalt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_password
     *
     * @mbggenerated
     */
    private String userPassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_email
     *
     * @mbggenerated
     */
    private String userEmail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_phone
     *
     * @mbggenerated
     */
    private String userPhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_gender
     *
     * @mbggenerated
     */
    private String userGender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_avatar
     *
     * @mbggenerated
     */
    private String userAvatar;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_role
     *
     * @mbggenerated
     */
    private String userRole;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_status
     *
     * @mbggenerated
     */
    private Integer userStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_registdate
     *
     * @mbggenerated
     */
    private Integer userRegistdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_registip
     *
     * @mbggenerated
     */
    private String userRegistip;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_lastloginip
     *
     * @mbggenerated
     */
    private String userLastloginip;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_address
     *
     * @mbggenerated
     */
    private String userAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.uid
     *
     * @return the value of user.uid
     *
     * @mbggenerated
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.uid
     *
     * @param uid the value for user.uid
     *
     * @mbggenerated
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_name
     *
     * @return the value of user.user_name
     *
     * @mbggenerated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_name
     *
     * @param userName the value for user.user_name
     *
     * @mbggenerated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_salt
     *
     * @return the value of user.user_salt
     *
     * @mbggenerated
     */
    public String getUserSalt() {
        return userSalt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_salt
     *
     * @param userSalt the value for user.user_salt
     *
     * @mbggenerated
     */
    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt == null ? null : userSalt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_password
     *
     * @return the value of user.user_password
     *
     * @mbggenerated
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_password
     *
     * @param userPassword the value for user.user_password
     *
     * @mbggenerated
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_email
     *
     * @return the value of user.user_email
     *
     * @mbggenerated
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_email
     *
     * @param userEmail the value for user.user_email
     *
     * @mbggenerated
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_phone
     *
     * @return the value of user.user_phone
     *
     * @mbggenerated
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_phone
     *
     * @param userPhone the value for user.user_phone
     *
     * @mbggenerated
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_gender
     *
     * @return the value of user.user_gender
     *
     * @mbggenerated
     */
    public String getUserGender() {
        return userGender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_gender
     *
     * @param userGender the value for user.user_gender
     *
     * @mbggenerated
     */
    public void setUserGender(String userGender) {
        this.userGender = userGender == null ? null : userGender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_avatar
     *
     * @return the value of user.user_avatar
     *
     * @mbggenerated
     */
    public String getUserAvatar() {
        return userAvatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_avatar
     *
     * @param userAvatar the value for user.user_avatar
     *
     * @mbggenerated
     */
    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar == null ? null : userAvatar.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_role
     *
     * @return the value of user.user_role
     *
     * @mbggenerated
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_role
     *
     * @param userRole the value for user.user_role
     *
     * @mbggenerated
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole == null ? null : userRole.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_status
     *
     * @return the value of user.user_status
     *
     * @mbggenerated
     */
    public Integer getUserStatus() {
        return userStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_status
     *
     * @param userStatus the value for user.user_status
     *
     * @mbggenerated
     */
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_registdate
     *
     * @return the value of user.user_registdate
     *
     * @mbggenerated
     */
    public Integer getUserRegistdate() {
        return userRegistdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_registdate
     *
     * @param userRegistdate the value for user.user_registdate
     *
     * @mbggenerated
     */
    public void setUserRegistdate(Integer userRegistdate) {
        this.userRegistdate = userRegistdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_registip
     *
     * @return the value of user.user_registip
     *
     * @mbggenerated
     */
    public String getUserRegistip() {
        return userRegistip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_registip
     *
     * @param userRegistip the value for user.user_registip
     *
     * @mbggenerated
     */
    public void setUserRegistip(String userRegistip) {
        this.userRegistip = userRegistip == null ? null : userRegistip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_lastloginip
     *
     * @return the value of user.user_lastloginip
     *
     * @mbggenerated
     */
    public String getUserLastloginip() {
        return userLastloginip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_lastloginip
     *
     * @param userLastloginip the value for user.user_lastloginip
     *
     * @mbggenerated
     */
    public void setUserLastloginip(String userLastloginip) {
        this.userLastloginip = userLastloginip == null ? null : userLastloginip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_address
     *
     * @return the value of user.user_address
     *
     * @mbggenerated
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_address
     *
     * @param userAddress the value for user.user_address
     *
     * @mbggenerated
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
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
        User other = (User) that;
        return (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getUserSalt() == null ? other.getUserSalt() == null : this.getUserSalt().equals(other.getUserSalt()))
            && (this.getUserPassword() == null ? other.getUserPassword() == null : this.getUserPassword().equals(other.getUserPassword()))
            && (this.getUserEmail() == null ? other.getUserEmail() == null : this.getUserEmail().equals(other.getUserEmail()))
            && (this.getUserPhone() == null ? other.getUserPhone() == null : this.getUserPhone().equals(other.getUserPhone()))
            && (this.getUserGender() == null ? other.getUserGender() == null : this.getUserGender().equals(other.getUserGender()))
            && (this.getUserAvatar() == null ? other.getUserAvatar() == null : this.getUserAvatar().equals(other.getUserAvatar()))
            && (this.getUserRole() == null ? other.getUserRole() == null : this.getUserRole().equals(other.getUserRole()))
            && (this.getUserStatus() == null ? other.getUserStatus() == null : this.getUserStatus().equals(other.getUserStatus()))
            && (this.getUserRegistdate() == null ? other.getUserRegistdate() == null : this.getUserRegistdate().equals(other.getUserRegistdate()))
            && (this.getUserRegistip() == null ? other.getUserRegistip() == null : this.getUserRegistip().equals(other.getUserRegistip()))
            && (this.getUserLastloginip() == null ? other.getUserLastloginip() == null : this.getUserLastloginip().equals(other.getUserLastloginip()))
            && (this.getUserAddress() == null ? other.getUserAddress() == null : this.getUserAddress().equals(other.getUserAddress()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getUserSalt() == null) ? 0 : getUserSalt().hashCode());
        result = prime * result + ((getUserPassword() == null) ? 0 : getUserPassword().hashCode());
        result = prime * result + ((getUserEmail() == null) ? 0 : getUserEmail().hashCode());
        result = prime * result + ((getUserPhone() == null) ? 0 : getUserPhone().hashCode());
        result = prime * result + ((getUserGender() == null) ? 0 : getUserGender().hashCode());
        result = prime * result + ((getUserAvatar() == null) ? 0 : getUserAvatar().hashCode());
        result = prime * result + ((getUserRole() == null) ? 0 : getUserRole().hashCode());
        result = prime * result + ((getUserStatus() == null) ? 0 : getUserStatus().hashCode());
        result = prime * result + ((getUserRegistdate() == null) ? 0 : getUserRegistdate().hashCode());
        result = prime * result + ((getUserRegistip() == null) ? 0 : getUserRegistip().hashCode());
        result = prime * result + ((getUserLastloginip() == null) ? 0 : getUserLastloginip().hashCode());
        result = prime * result + ((getUserAddress() == null) ? 0 : getUserAddress().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", userName=").append(userName);
        sb.append(", userSalt=").append(userSalt);
        sb.append(", userPassword=").append(userPassword);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", userGender=").append(userGender);
        sb.append(", userAvatar=").append(userAvatar);
        sb.append(", userRole=").append(userRole);
        sb.append(", userStatus=").append(userStatus);
        sb.append(", userRegistdate=").append(userRegistdate);
        sb.append(", userRegistip=").append(userRegistip);
        sb.append(", userLastloginip=").append(userLastloginip);
        sb.append(", userAddress=").append(userAddress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}