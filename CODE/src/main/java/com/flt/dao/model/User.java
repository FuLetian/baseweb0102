package com.flt.dao.model;

public class User {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.id
	 * @mbggenerated  Wed Jan 29 23:12:01 CST 2014
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.account
	 * @mbggenerated  Wed Jan 29 23:12:01 CST 2014
	 */
	private String account;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.password
	 * @mbggenerated  Wed Jan 29 23:12:01 CST 2014
	 */
	private String password;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.domain
	 * @mbggenerated  Wed Jan 29 23:12:01 CST 2014
	 */
	private String domain;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.id
	 * @return  the value of user.id
	 * @mbggenerated  Wed Jan 29 23:12:01 CST 2014
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.id
	 * @param id  the value for user.id
	 * @mbggenerated  Wed Jan 29 23:12:01 CST 2014
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.account
	 * @return  the value of user.account
	 * @mbggenerated  Wed Jan 29 23:12:01 CST 2014
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.account
	 * @param account  the value for user.account
	 * @mbggenerated  Wed Jan 29 23:12:01 CST 2014
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.password
	 * @return  the value of user.password
	 * @mbggenerated  Wed Jan 29 23:12:01 CST 2014
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.password
	 * @param password  the value for user.password
	 * @mbggenerated  Wed Jan 29 23:12:01 CST 2014
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.domain
	 * @return  the value of user.domain
	 * @mbggenerated  Wed Jan 29 23:12:01 CST 2014
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.domain
	 * @param domain  the value for user.domain
	 * @mbggenerated  Wed Jan 29 23:12:01 CST 2014
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}
}