package com.flt.dao.model;

import java.util.Date;

public class Channel {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column channel.id
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column channel.name
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column channel.u_dt
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	private Date uDt;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column channel.c_dt
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	private Date cDt;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column channel.idx
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	private Integer idx;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column channel.user_id
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	private Integer userId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column channel.id
	 * @return  the value of channel.id
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column channel.id
	 * @param id  the value for channel.id
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column channel.name
	 * @return  the value of channel.name
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column channel.name
	 * @param name  the value for channel.name
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column channel.u_dt
	 * @return  the value of channel.u_dt
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public Date getuDt() {
		return uDt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column channel.u_dt
	 * @param uDt  the value for channel.u_dt
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public void setuDt(Date uDt) {
		this.uDt = uDt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column channel.c_dt
	 * @return  the value of channel.c_dt
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public Date getcDt() {
		return cDt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column channel.c_dt
	 * @param cDt  the value for channel.c_dt
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public void setcDt(Date cDt) {
		this.cDt = cDt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column channel.idx
	 * @return  the value of channel.idx
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public Integer getIdx() {
		return idx;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column channel.idx
	 * @param idx  the value for channel.idx
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column channel.user_id
	 * @return  the value of channel.user_id
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column channel.user_id
	 * @param userId  the value for channel.user_id
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}