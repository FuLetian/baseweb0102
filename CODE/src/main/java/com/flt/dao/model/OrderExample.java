package com.flt.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_order
	 * @mbggenerated  Fri Feb 28 10:42:24 CST 2014
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_order
	 * @mbggenerated  Fri Feb 28 10:42:24 CST 2014
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_order
	 * @mbggenerated  Fri Feb 28 10:42:24 CST 2014
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_order
	 * @mbggenerated  Fri Feb 28 10:42:24 CST 2014
	 */
	public OrderExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_order
	 * @mbggenerated  Fri Feb 28 10:42:24 CST 2014
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_order
	 * @mbggenerated  Fri Feb 28 10:42:24 CST 2014
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_order
	 * @mbggenerated  Fri Feb 28 10:42:24 CST 2014
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_order
	 * @mbggenerated  Fri Feb 28 10:42:24 CST 2014
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_order
	 * @mbggenerated  Fri Feb 28 10:42:24 CST 2014
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_order
	 * @mbggenerated  Fri Feb 28 10:42:24 CST 2014
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_order
	 * @mbggenerated  Fri Feb 28 10:42:24 CST 2014
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_order
	 * @mbggenerated  Fri Feb 28 10:42:24 CST 2014
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_order
	 * @mbggenerated  Fri Feb 28 10:42:24 CST 2014
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_order
	 * @mbggenerated  Fri Feb 28 10:42:24 CST 2014
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_order
	 * @mbggenerated  Fri Feb 28 10:42:24 CST 2014
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andCountIsNull() {
			addCriterion("count is null");
			return (Criteria) this;
		}

		public Criteria andCountIsNotNull() {
			addCriterion("count is not null");
			return (Criteria) this;
		}

		public Criteria andCountEqualTo(Integer value) {
			addCriterion("count =", value, "count");
			return (Criteria) this;
		}

		public Criteria andCountNotEqualTo(Integer value) {
			addCriterion("count <>", value, "count");
			return (Criteria) this;
		}

		public Criteria andCountGreaterThan(Integer value) {
			addCriterion("count >", value, "count");
			return (Criteria) this;
		}

		public Criteria andCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("count >=", value, "count");
			return (Criteria) this;
		}

		public Criteria andCountLessThan(Integer value) {
			addCriterion("count <", value, "count");
			return (Criteria) this;
		}

		public Criteria andCountLessThanOrEqualTo(Integer value) {
			addCriterion("count <=", value, "count");
			return (Criteria) this;
		}

		public Criteria andCountIn(List<Integer> values) {
			addCriterion("count in", values, "count");
			return (Criteria) this;
		}

		public Criteria andCountNotIn(List<Integer> values) {
			addCriterion("count not in", values, "count");
			return (Criteria) this;
		}

		public Criteria andCountBetween(Integer value1, Integer value2) {
			addCriterion("count between", value1, value2, "count");
			return (Criteria) this;
		}

		public Criteria andCountNotBetween(Integer value1, Integer value2) {
			addCriterion("count not between", value1, value2, "count");
			return (Criteria) this;
		}

		public Criteria andRunStatusIsNull() {
			addCriterion("run_status is null");
			return (Criteria) this;
		}

		public Criteria andRunStatusIsNotNull() {
			addCriterion("run_status is not null");
			return (Criteria) this;
		}

		public Criteria andRunStatusEqualTo(Integer value) {
			addCriterion("run_status =", value, "runStatus");
			return (Criteria) this;
		}

		public Criteria andRunStatusNotEqualTo(Integer value) {
			addCriterion("run_status <>", value, "runStatus");
			return (Criteria) this;
		}

		public Criteria andRunStatusGreaterThan(Integer value) {
			addCriterion("run_status >", value, "runStatus");
			return (Criteria) this;
		}

		public Criteria andRunStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("run_status >=", value, "runStatus");
			return (Criteria) this;
		}

		public Criteria andRunStatusLessThan(Integer value) {
			addCriterion("run_status <", value, "runStatus");
			return (Criteria) this;
		}

		public Criteria andRunStatusLessThanOrEqualTo(Integer value) {
			addCriterion("run_status <=", value, "runStatus");
			return (Criteria) this;
		}

		public Criteria andRunStatusIn(List<Integer> values) {
			addCriterion("run_status in", values, "runStatus");
			return (Criteria) this;
		}

		public Criteria andRunStatusNotIn(List<Integer> values) {
			addCriterion("run_status not in", values, "runStatus");
			return (Criteria) this;
		}

		public Criteria andRunStatusBetween(Integer value1, Integer value2) {
			addCriterion("run_status between", value1, value2, "runStatus");
			return (Criteria) this;
		}

		public Criteria andRunStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("run_status not between", value1, value2, "runStatus");
			return (Criteria) this;
		}

		public Criteria andTourNameIsNull() {
			addCriterion("tour_name is null");
			return (Criteria) this;
		}

		public Criteria andTourNameIsNotNull() {
			addCriterion("tour_name is not null");
			return (Criteria) this;
		}

		public Criteria andTourNameEqualTo(String value) {
			addCriterion("tour_name =", value, "tourName");
			return (Criteria) this;
		}

		public Criteria andTourNameNotEqualTo(String value) {
			addCriterion("tour_name <>", value, "tourName");
			return (Criteria) this;
		}

		public Criteria andTourNameGreaterThan(String value) {
			addCriterion("tour_name >", value, "tourName");
			return (Criteria) this;
		}

		public Criteria andTourNameGreaterThanOrEqualTo(String value) {
			addCriterion("tour_name >=", value, "tourName");
			return (Criteria) this;
		}

		public Criteria andTourNameLessThan(String value) {
			addCriterion("tour_name <", value, "tourName");
			return (Criteria) this;
		}

		public Criteria andTourNameLessThanOrEqualTo(String value) {
			addCriterion("tour_name <=", value, "tourName");
			return (Criteria) this;
		}

		public Criteria andTourNameLike(String value) {
			addCriterion("tour_name like", value, "tourName");
			return (Criteria) this;
		}

		public Criteria andTourNameNotLike(String value) {
			addCriterion("tour_name not like", value, "tourName");
			return (Criteria) this;
		}

		public Criteria andTourNameIn(List<String> values) {
			addCriterion("tour_name in", values, "tourName");
			return (Criteria) this;
		}

		public Criteria andTourNameNotIn(List<String> values) {
			addCriterion("tour_name not in", values, "tourName");
			return (Criteria) this;
		}

		public Criteria andTourNameBetween(String value1, String value2) {
			addCriterion("tour_name between", value1, value2, "tourName");
			return (Criteria) this;
		}

		public Criteria andTourNameNotBetween(String value1, String value2) {
			addCriterion("tour_name not between", value1, value2, "tourName");
			return (Criteria) this;
		}

		public Criteria andTourEmailIsNull() {
			addCriterion("tour_email is null");
			return (Criteria) this;
		}

		public Criteria andTourEmailIsNotNull() {
			addCriterion("tour_email is not null");
			return (Criteria) this;
		}

		public Criteria andTourEmailEqualTo(String value) {
			addCriterion("tour_email =", value, "tourEmail");
			return (Criteria) this;
		}

		public Criteria andTourEmailNotEqualTo(String value) {
			addCriterion("tour_email <>", value, "tourEmail");
			return (Criteria) this;
		}

		public Criteria andTourEmailGreaterThan(String value) {
			addCriterion("tour_email >", value, "tourEmail");
			return (Criteria) this;
		}

		public Criteria andTourEmailGreaterThanOrEqualTo(String value) {
			addCriterion("tour_email >=", value, "tourEmail");
			return (Criteria) this;
		}

		public Criteria andTourEmailLessThan(String value) {
			addCriterion("tour_email <", value, "tourEmail");
			return (Criteria) this;
		}

		public Criteria andTourEmailLessThanOrEqualTo(String value) {
			addCriterion("tour_email <=", value, "tourEmail");
			return (Criteria) this;
		}

		public Criteria andTourEmailLike(String value) {
			addCriterion("tour_email like", value, "tourEmail");
			return (Criteria) this;
		}

		public Criteria andTourEmailNotLike(String value) {
			addCriterion("tour_email not like", value, "tourEmail");
			return (Criteria) this;
		}

		public Criteria andTourEmailIn(List<String> values) {
			addCriterion("tour_email in", values, "tourEmail");
			return (Criteria) this;
		}

		public Criteria andTourEmailNotIn(List<String> values) {
			addCriterion("tour_email not in", values, "tourEmail");
			return (Criteria) this;
		}

		public Criteria andTourEmailBetween(String value1, String value2) {
			addCriterion("tour_email between", value1, value2, "tourEmail");
			return (Criteria) this;
		}

		public Criteria andTourEmailNotBetween(String value1, String value2) {
			addCriterion("tour_email not between", value1, value2, "tourEmail");
			return (Criteria) this;
		}

		public Criteria andTourPhoneIsNull() {
			addCriterion("tour_phone is null");
			return (Criteria) this;
		}

		public Criteria andTourPhoneIsNotNull() {
			addCriterion("tour_phone is not null");
			return (Criteria) this;
		}

		public Criteria andTourPhoneEqualTo(String value) {
			addCriterion("tour_phone =", value, "tourPhone");
			return (Criteria) this;
		}

		public Criteria andTourPhoneNotEqualTo(String value) {
			addCriterion("tour_phone <>", value, "tourPhone");
			return (Criteria) this;
		}

		public Criteria andTourPhoneGreaterThan(String value) {
			addCriterion("tour_phone >", value, "tourPhone");
			return (Criteria) this;
		}

		public Criteria andTourPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("tour_phone >=", value, "tourPhone");
			return (Criteria) this;
		}

		public Criteria andTourPhoneLessThan(String value) {
			addCriterion("tour_phone <", value, "tourPhone");
			return (Criteria) this;
		}

		public Criteria andTourPhoneLessThanOrEqualTo(String value) {
			addCriterion("tour_phone <=", value, "tourPhone");
			return (Criteria) this;
		}

		public Criteria andTourPhoneLike(String value) {
			addCriterion("tour_phone like", value, "tourPhone");
			return (Criteria) this;
		}

		public Criteria andTourPhoneNotLike(String value) {
			addCriterion("tour_phone not like", value, "tourPhone");
			return (Criteria) this;
		}

		public Criteria andTourPhoneIn(List<String> values) {
			addCriterion("tour_phone in", values, "tourPhone");
			return (Criteria) this;
		}

		public Criteria andTourPhoneNotIn(List<String> values) {
			addCriterion("tour_phone not in", values, "tourPhone");
			return (Criteria) this;
		}

		public Criteria andTourPhoneBetween(String value1, String value2) {
			addCriterion("tour_phone between", value1, value2, "tourPhone");
			return (Criteria) this;
		}

		public Criteria andTourPhoneNotBetween(String value1, String value2) {
			addCriterion("tour_phone not between", value1, value2, "tourPhone");
			return (Criteria) this;
		}

		public Criteria andTourAddressIsNull() {
			addCriterion("tour_address is null");
			return (Criteria) this;
		}

		public Criteria andTourAddressIsNotNull() {
			addCriterion("tour_address is not null");
			return (Criteria) this;
		}

		public Criteria andTourAddressEqualTo(String value) {
			addCriterion("tour_address =", value, "tourAddress");
			return (Criteria) this;
		}

		public Criteria andTourAddressNotEqualTo(String value) {
			addCriterion("tour_address <>", value, "tourAddress");
			return (Criteria) this;
		}

		public Criteria andTourAddressGreaterThan(String value) {
			addCriterion("tour_address >", value, "tourAddress");
			return (Criteria) this;
		}

		public Criteria andTourAddressGreaterThanOrEqualTo(String value) {
			addCriterion("tour_address >=", value, "tourAddress");
			return (Criteria) this;
		}

		public Criteria andTourAddressLessThan(String value) {
			addCriterion("tour_address <", value, "tourAddress");
			return (Criteria) this;
		}

		public Criteria andTourAddressLessThanOrEqualTo(String value) {
			addCriterion("tour_address <=", value, "tourAddress");
			return (Criteria) this;
		}

		public Criteria andTourAddressLike(String value) {
			addCriterion("tour_address like", value, "tourAddress");
			return (Criteria) this;
		}

		public Criteria andTourAddressNotLike(String value) {
			addCriterion("tour_address not like", value, "tourAddress");
			return (Criteria) this;
		}

		public Criteria andTourAddressIn(List<String> values) {
			addCriterion("tour_address in", values, "tourAddress");
			return (Criteria) this;
		}

		public Criteria andTourAddressNotIn(List<String> values) {
			addCriterion("tour_address not in", values, "tourAddress");
			return (Criteria) this;
		}

		public Criteria andTourAddressBetween(String value1, String value2) {
			addCriterion("tour_address between", value1, value2, "tourAddress");
			return (Criteria) this;
		}

		public Criteria andTourAddressNotBetween(String value1, String value2) {
			addCriterion("tour_address not between", value1, value2,
					"tourAddress");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNull() {
			addCriterion("remark is null");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNotNull() {
			addCriterion("remark is not null");
			return (Criteria) this;
		}

		public Criteria andRemarkEqualTo(String value) {
			addCriterion("remark =", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotEqualTo(String value) {
			addCriterion("remark <>", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThan(String value) {
			addCriterion("remark >", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("remark >=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThan(String value) {
			addCriterion("remark <", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThanOrEqualTo(String value) {
			addCriterion("remark <=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLike(String value) {
			addCriterion("remark like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotLike(String value) {
			addCriterion("remark not like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkIn(List<String> values) {
			addCriterion("remark in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotIn(List<String> values) {
			addCriterion("remark not in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkBetween(String value1, String value2) {
			addCriterion("remark between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotBetween(String value1, String value2) {
			addCriterion("remark not between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andUDtIsNull() {
			addCriterion("u_dt is null");
			return (Criteria) this;
		}

		public Criteria andUDtIsNotNull() {
			addCriterion("u_dt is not null");
			return (Criteria) this;
		}

		public Criteria andUDtEqualTo(Date value) {
			addCriterion("u_dt =", value, "uDt");
			return (Criteria) this;
		}

		public Criteria andUDtNotEqualTo(Date value) {
			addCriterion("u_dt <>", value, "uDt");
			return (Criteria) this;
		}

		public Criteria andUDtGreaterThan(Date value) {
			addCriterion("u_dt >", value, "uDt");
			return (Criteria) this;
		}

		public Criteria andUDtGreaterThanOrEqualTo(Date value) {
			addCriterion("u_dt >=", value, "uDt");
			return (Criteria) this;
		}

		public Criteria andUDtLessThan(Date value) {
			addCriterion("u_dt <", value, "uDt");
			return (Criteria) this;
		}

		public Criteria andUDtLessThanOrEqualTo(Date value) {
			addCriterion("u_dt <=", value, "uDt");
			return (Criteria) this;
		}

		public Criteria andUDtIn(List<Date> values) {
			addCriterion("u_dt in", values, "uDt");
			return (Criteria) this;
		}

		public Criteria andUDtNotIn(List<Date> values) {
			addCriterion("u_dt not in", values, "uDt");
			return (Criteria) this;
		}

		public Criteria andUDtBetween(Date value1, Date value2) {
			addCriterion("u_dt between", value1, value2, "uDt");
			return (Criteria) this;
		}

		public Criteria andUDtNotBetween(Date value1, Date value2) {
			addCriterion("u_dt not between", value1, value2, "uDt");
			return (Criteria) this;
		}

		public Criteria andCDtIsNull() {
			addCriterion("c_dt is null");
			return (Criteria) this;
		}

		public Criteria andCDtIsNotNull() {
			addCriterion("c_dt is not null");
			return (Criteria) this;
		}

		public Criteria andCDtEqualTo(Date value) {
			addCriterion("c_dt =", value, "cDt");
			return (Criteria) this;
		}

		public Criteria andCDtNotEqualTo(Date value) {
			addCriterion("c_dt <>", value, "cDt");
			return (Criteria) this;
		}

		public Criteria andCDtGreaterThan(Date value) {
			addCriterion("c_dt >", value, "cDt");
			return (Criteria) this;
		}

		public Criteria andCDtGreaterThanOrEqualTo(Date value) {
			addCriterion("c_dt >=", value, "cDt");
			return (Criteria) this;
		}

		public Criteria andCDtLessThan(Date value) {
			addCriterion("c_dt <", value, "cDt");
			return (Criteria) this;
		}

		public Criteria andCDtLessThanOrEqualTo(Date value) {
			addCriterion("c_dt <=", value, "cDt");
			return (Criteria) this;
		}

		public Criteria andCDtIn(List<Date> values) {
			addCriterion("c_dt in", values, "cDt");
			return (Criteria) this;
		}

		public Criteria andCDtNotIn(List<Date> values) {
			addCriterion("c_dt not in", values, "cDt");
			return (Criteria) this;
		}

		public Criteria andCDtBetween(Date value1, Date value2) {
			addCriterion("c_dt between", value1, value2, "cDt");
			return (Criteria) this;
		}

		public Criteria andCDtNotBetween(Date value1, Date value2) {
			addCriterion("c_dt not between", value1, value2, "cDt");
			return (Criteria) this;
		}

		public Criteria andConsumerIdIsNull() {
			addCriterion("consumer_id is null");
			return (Criteria) this;
		}

		public Criteria andConsumerIdIsNotNull() {
			addCriterion("consumer_id is not null");
			return (Criteria) this;
		}

		public Criteria andConsumerIdEqualTo(Integer value) {
			addCriterion("consumer_id =", value, "consumerId");
			return (Criteria) this;
		}

		public Criteria andConsumerIdNotEqualTo(Integer value) {
			addCriterion("consumer_id <>", value, "consumerId");
			return (Criteria) this;
		}

		public Criteria andConsumerIdGreaterThan(Integer value) {
			addCriterion("consumer_id >", value, "consumerId");
			return (Criteria) this;
		}

		public Criteria andConsumerIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("consumer_id >=", value, "consumerId");
			return (Criteria) this;
		}

		public Criteria andConsumerIdLessThan(Integer value) {
			addCriterion("consumer_id <", value, "consumerId");
			return (Criteria) this;
		}

		public Criteria andConsumerIdLessThanOrEqualTo(Integer value) {
			addCriterion("consumer_id <=", value, "consumerId");
			return (Criteria) this;
		}

		public Criteria andConsumerIdIn(List<Integer> values) {
			addCriterion("consumer_id in", values, "consumerId");
			return (Criteria) this;
		}

		public Criteria andConsumerIdNotIn(List<Integer> values) {
			addCriterion("consumer_id not in", values, "consumerId");
			return (Criteria) this;
		}

		public Criteria andConsumerIdBetween(Integer value1, Integer value2) {
			addCriterion("consumer_id between", value1, value2, "consumerId");
			return (Criteria) this;
		}

		public Criteria andConsumerIdNotBetween(Integer value1, Integer value2) {
			addCriterion("consumer_id not between", value1, value2,
					"consumerId");
			return (Criteria) this;
		}

		public Criteria andArticleIdIsNull() {
			addCriterion("article_id is null");
			return (Criteria) this;
		}

		public Criteria andArticleIdIsNotNull() {
			addCriterion("article_id is not null");
			return (Criteria) this;
		}

		public Criteria andArticleIdEqualTo(Integer value) {
			addCriterion("article_id =", value, "articleId");
			return (Criteria) this;
		}

		public Criteria andArticleIdNotEqualTo(Integer value) {
			addCriterion("article_id <>", value, "articleId");
			return (Criteria) this;
		}

		public Criteria andArticleIdGreaterThan(Integer value) {
			addCriterion("article_id >", value, "articleId");
			return (Criteria) this;
		}

		public Criteria andArticleIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("article_id >=", value, "articleId");
			return (Criteria) this;
		}

		public Criteria andArticleIdLessThan(Integer value) {
			addCriterion("article_id <", value, "articleId");
			return (Criteria) this;
		}

		public Criteria andArticleIdLessThanOrEqualTo(Integer value) {
			addCriterion("article_id <=", value, "articleId");
			return (Criteria) this;
		}

		public Criteria andArticleIdIn(List<Integer> values) {
			addCriterion("article_id in", values, "articleId");
			return (Criteria) this;
		}

		public Criteria andArticleIdNotIn(List<Integer> values) {
			addCriterion("article_id not in", values, "articleId");
			return (Criteria) this;
		}

		public Criteria andArticleIdBetween(Integer value1, Integer value2) {
			addCriterion("article_id between", value1, value2, "articleId");
			return (Criteria) this;
		}

		public Criteria andArticleIdNotBetween(Integer value1, Integer value2) {
			addCriterion("article_id not between", value1, value2, "articleId");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_order
	 * @mbggenerated  Fri Feb 28 10:42:24 CST 2014
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table order
     *
     * @mbggenerated do_not_delete_during_merge Mon Jan 27 16:21:03 CST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}