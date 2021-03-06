package com.ssm.model;

import java.io.Serializable;

public class Comment implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.cid
     *
     * @mbggenerated
     */
    private Long cid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.pid
     *
     * @mbggenerated
     */
    private Long pid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.authorid
     *
     * @mbggenerated
     */
    private Long authorid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.type
     *
     * @mbggenerated
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.reply_to
     *
     * @mbggenerated
     */
    private Long replyTo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.create_at
     *
     * @mbggenerated
     */
    private Long createAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table comment
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.cid
     *
     * @return the value of comment.cid
     *
     * @mbggenerated
     */
    public Long getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.cid
     *
     * @param cid the value for comment.cid
     *
     * @mbggenerated
     */
    public void setCid(Long cid) {
        this.cid = cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.pid
     *
     * @return the value of comment.pid
     *
     * @mbggenerated
     */
    public Long getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.pid
     *
     * @param pid the value for comment.pid
     *
     * @mbggenerated
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.authorid
     *
     * @return the value of comment.authorid
     *
     * @mbggenerated
     */
    public Long getAuthorid() {
        return authorid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.authorid
     *
     * @param authorid the value for comment.authorid
     *
     * @mbggenerated
     */
    public void setAuthorid(Long authorid) {
        this.authorid = authorid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.type
     *
     * @return the value of comment.type
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.type
     *
     * @param type the value for comment.type
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.reply_to
     *
     * @return the value of comment.reply_to
     *
     * @mbggenerated
     */
    public Long getReplyTo() {
        return replyTo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.reply_to
     *
     * @param replyTo the value for comment.reply_to
     *
     * @mbggenerated
     */
    public void setReplyTo(Long replyTo) {
        this.replyTo = replyTo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.create_at
     *
     * @return the value of comment.create_at
     *
     * @mbggenerated
     */
    public Long getCreateAt() {
        return createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.create_at
     *
     * @param createAt the value for comment.create_at
     *
     * @mbggenerated
     */
    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.content
     *
     * @return the value of comment.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.content
     *
     * @param content the value for comment.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment
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
        Comment other = (Comment) that;
        return (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getAuthorid() == null ? other.getAuthorid() == null : this.getAuthorid().equals(other.getAuthorid()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getReplyTo() == null ? other.getReplyTo() == null : this.getReplyTo().equals(other.getReplyTo()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getAuthorid() == null) ? 0 : getAuthorid().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getReplyTo() == null) ? 0 : getReplyTo().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cid=").append(cid);
        sb.append(", pid=").append(pid);
        sb.append(", authorid=").append(authorid);
        sb.append(", type=").append(type);
        sb.append(", replyTo=").append(replyTo);
        sb.append(", createAt=").append(createAt);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}