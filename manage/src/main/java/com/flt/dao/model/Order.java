package com.flt.dao.model;

import java.util.Date;

public class Order {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_order.id
	 * @mbggenerated  Fri Jan 31 14:52:07 CST 2014
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_order.count
	 * @mbggenerated  Fri Jan 31 14:52:07 CST 2014
	 */
	private Integer count;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_order.run_status
	 * @mbggenerated  Fri Jan 31 14:52:07 CST 2014
	 */
	private Integer runStatus;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_order.remark
	 * @mbggenerated  Fri Jan 31 14:52:07 CST 2014
	 */
	private String remark;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_order.u_dt
	 * @mbggenerated  Fri Jan 31 14:52:07 CST 2014
	 */
	private Date uDt;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_order.c_dt
	 * @mbggenerated  Fri Jan 31 14:52:07 CST 2014
	 */
	private Date cDt;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_order.consumer_id
	 * @mbggenerated  Fri Jan 31 14:52:07 CST 2014
	 */
	private Integer consumerId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_order.article_id
	 * @mbggenerated  Fri Jan 31 14:52:07 CST 2014
	 */
	private Integer articleId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_order.id
	 * @return  the value of t_order.id
	 * @mbggenerated  Fri Jan 31 14:52:07 CST 2014
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_order.id
	 * @param id  the value for t_order.id
	 * @mbggenerated  Fri Jan 31 14:52:07 CST 2014
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_order.count
	 * @return  the value of t_order.count
	 * @mbggenerated  Fri Jan 31 14:52:07 CST 2014
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_order.count
	 * @param count  the value for t_order.count
	 * @mbggenerated  Fri Jan 31 14:52:07 CST 2014
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_order.run_status
	 * @return  the value of t_order.run_status
	 * @mbggenerated  Fri Jan 31 14:52:07 CST 2014
	 */
	public Integer getRunStatus() {
		return runStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_order.run_status
	 * @param runStatus  the value for t_order.run_status
	 * @mbggenerated  Fri Jan 31 14:52:07 CST 2014
	 */
	public void setRunStatus(Integer runStatus) {
		this.runStatus = runStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_order.remark
	 * @return  the value of t_order.remark
	 * @mbggenerated  Fri Jan 31 14:52:07 CST 2014
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_order.remark
	 * @param remark  the value for t_order.remark
	 * @mbggenerated  Fri Jan 31 14:52:07 CST 2014
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_order.u_dt
	 * @return  the value of t_order.u_dt
	 * @mbggenerated  Fri Jan 31 14:52:07 CST 2014
	 */
	public Date getuDt() {
		return uDt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_order.u_dt
	 * @param uDt  the value for t_order.u_dt
	 * @mbggenerated  Fri Jan 31 14:52:07 CST 2014
	 */
	public void setuDt(Date uDt) {
		this.uDt = uDt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_order.c_dt
	 * @return  the value of t_order.c_dt
	 * @mbggenerated  Fri Jan 31 14:52:07 CST 2014
	 */
	public Date getcDt() {
		return cDt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_order.c_dt
	 * @param cDt  the value for t_order.c_dt
	 * @mbggenerated  Fri Jan 31 14:52:07 CST 2014
	 */
	public void setcDt(Date cDt) {
		this.cDt = cDt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_order.consumer_id
	 * @return  the value of t_order.consumer_id
	 * @mbggenerated  Fri Jan 31 14:52:07 CST 2014
	 */
	public Integer getConsumerId() {
		return consumerId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_order.consumer_id
	 * @param consumerId  the value for t_order.consumer_id
	 * @mbggenerated  Fri Jan 31 14:52:07 CST 2014
	 */
	public void setConsumerId(Integer consumerId) {
		this.consumerId = consumerId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_order.article_id
	 * @return  the value of t_order.article_id
	 * @mbggenerated  Fri Jan 31 14:52:07 CST 2014
	 */
	public Integer getArticleId() {
		return articleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_order.article_id
	 * @param articleId  the value for t_order.article_id
	 * @mbggenerated  Fri Jan 31 14:52:07 CST 2014
	 */
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
}