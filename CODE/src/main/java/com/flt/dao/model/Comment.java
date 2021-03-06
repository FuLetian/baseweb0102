package com.flt.dao.model;

import java.util.Date;

public class Comment {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column comment.id
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column comment.content
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	private String content;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column comment.reply_content
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	private String replyContent;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column comment.grade
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	private Integer grade;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column comment.u_dt
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	private Date uDt;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column comment.c_dt
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	private Date cDt;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column comment.article_id
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	private Integer articleId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column comment.consumer_id
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	private Integer consumerId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column comment.user_id
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	private Integer userId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column comment.id
	 * @return  the value of comment.id
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column comment.id
	 * @param id  the value for comment.id
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column comment.content
	 * @return  the value of comment.content
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public String getContent() {
		return content;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column comment.content
	 * @param content  the value for comment.content
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column comment.reply_content
	 * @return  the value of comment.reply_content
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public String getReplyContent() {
		return replyContent;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column comment.reply_content
	 * @param replyContent  the value for comment.reply_content
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column comment.grade
	 * @return  the value of comment.grade
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public Integer getGrade() {
		return grade;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column comment.grade
	 * @param grade  the value for comment.grade
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column comment.u_dt
	 * @return  the value of comment.u_dt
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public Date getuDt() {
		return uDt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column comment.u_dt
	 * @param uDt  the value for comment.u_dt
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public void setuDt(Date uDt) {
		this.uDt = uDt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column comment.c_dt
	 * @return  the value of comment.c_dt
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public Date getcDt() {
		return cDt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column comment.c_dt
	 * @param cDt  the value for comment.c_dt
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public void setcDt(Date cDt) {
		this.cDt = cDt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column comment.article_id
	 * @return  the value of comment.article_id
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public Integer getArticleId() {
		return articleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column comment.article_id
	 * @param articleId  the value for comment.article_id
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column comment.consumer_id
	 * @return  the value of comment.consumer_id
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public Integer getConsumerId() {
		return consumerId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column comment.consumer_id
	 * @param consumerId  the value for comment.consumer_id
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public void setConsumerId(Integer consumerId) {
		this.consumerId = consumerId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column comment.user_id
	 * @return  the value of comment.user_id
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column comment.user_id
	 * @param userId  the value for comment.user_id
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}