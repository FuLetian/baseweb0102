package com.flt.dao.model;

import java.util.Date;

public class AccessLog {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column access_log.id
	 * @mbggenerated  Thu Mar 06 09:56:06 CST 2014
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column access_log.ip
	 * @mbggenerated  Thu Mar 06 09:56:06 CST 2014
	 */
	private String ip;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column access_log.lunch_dt
	 * @mbggenerated  Thu Mar 06 09:56:06 CST 2014
	 */
	private Date lunchDt;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column access_log.consumer_id
	 * @mbggenerated  Thu Mar 06 09:56:06 CST 2014
	 */
	private Integer consumerId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column access_log.user_id
	 * @mbggenerated  Thu Mar 06 09:56:06 CST 2014
	 */
	private Integer userId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column access_log.id
	 * @return  the value of access_log.id
	 * @mbggenerated  Thu Mar 06 09:56:06 CST 2014
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column access_log.id
	 * @param id  the value for access_log.id
	 * @mbggenerated  Thu Mar 06 09:56:06 CST 2014
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column access_log.ip
	 * @return  the value of access_log.ip
	 * @mbggenerated  Thu Mar 06 09:56:06 CST 2014
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column access_log.ip
	 * @param ip  the value for access_log.ip
	 * @mbggenerated  Thu Mar 06 09:56:06 CST 2014
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column access_log.lunch_dt
	 * @return  the value of access_log.lunch_dt
	 * @mbggenerated  Thu Mar 06 09:56:06 CST 2014
	 */
	public Date getLunchDt() {
		return lunchDt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column access_log.lunch_dt
	 * @param lunchDt  the value for access_log.lunch_dt
	 * @mbggenerated  Thu Mar 06 09:56:06 CST 2014
	 */
	public void setLunchDt(Date lunchDt) {
		this.lunchDt = lunchDt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column access_log.consumer_id
	 * @return  the value of access_log.consumer_id
	 * @mbggenerated  Thu Mar 06 09:56:06 CST 2014
	 */
	public Integer getConsumerId() {
		return consumerId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column access_log.consumer_id
	 * @param consumerId  the value for access_log.consumer_id
	 * @mbggenerated  Thu Mar 06 09:56:06 CST 2014
	 */
	public void setConsumerId(Integer consumerId) {
		this.consumerId = consumerId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column access_log.user_id
	 * @return  the value of access_log.user_id
	 * @mbggenerated  Thu Mar 06 09:56:06 CST 2014
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column access_log.user_id
	 * @param userId  the value for access_log.user_id
	 * @mbggenerated  Thu Mar 06 09:56:06 CST 2014
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}