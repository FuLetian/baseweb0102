package com.flt.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BallExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table ball
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table ball
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table ball
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ball
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	public BallExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ball
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ball
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ball
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ball
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ball
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ball
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ball
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ball
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ball
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ball
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table ball
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
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

		public Criteria andTermIsNull() {
			addCriterion("term is null");
			return (Criteria) this;
		}

		public Criteria andTermIsNotNull() {
			addCriterion("term is not null");
			return (Criteria) this;
		}

		public Criteria andTermEqualTo(Integer value) {
			addCriterion("term =", value, "term");
			return (Criteria) this;
		}

		public Criteria andTermNotEqualTo(Integer value) {
			addCriterion("term <>", value, "term");
			return (Criteria) this;
		}

		public Criteria andTermGreaterThan(Integer value) {
			addCriterion("term >", value, "term");
			return (Criteria) this;
		}

		public Criteria andTermGreaterThanOrEqualTo(Integer value) {
			addCriterion("term >=", value, "term");
			return (Criteria) this;
		}

		public Criteria andTermLessThan(Integer value) {
			addCriterion("term <", value, "term");
			return (Criteria) this;
		}

		public Criteria andTermLessThanOrEqualTo(Integer value) {
			addCriterion("term <=", value, "term");
			return (Criteria) this;
		}

		public Criteria andTermIn(List<Integer> values) {
			addCriterion("term in", values, "term");
			return (Criteria) this;
		}

		public Criteria andTermNotIn(List<Integer> values) {
			addCriterion("term not in", values, "term");
			return (Criteria) this;
		}

		public Criteria andTermBetween(Integer value1, Integer value2) {
			addCriterion("term between", value1, value2, "term");
			return (Criteria) this;
		}

		public Criteria andTermNotBetween(Integer value1, Integer value2) {
			addCriterion("term not between", value1, value2, "term");
			return (Criteria) this;
		}

		public Criteria andMakeDateTimeIsNull() {
			addCriterion("make_date_time is null");
			return (Criteria) this;
		}

		public Criteria andMakeDateTimeIsNotNull() {
			addCriterion("make_date_time is not null");
			return (Criteria) this;
		}

		public Criteria andMakeDateTimeEqualTo(Date value) {
			addCriterion("make_date_time =", value, "makeDateTime");
			return (Criteria) this;
		}

		public Criteria andMakeDateTimeNotEqualTo(Date value) {
			addCriterion("make_date_time <>", value, "makeDateTime");
			return (Criteria) this;
		}

		public Criteria andMakeDateTimeGreaterThan(Date value) {
			addCriterion("make_date_time >", value, "makeDateTime");
			return (Criteria) this;
		}

		public Criteria andMakeDateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("make_date_time >=", value, "makeDateTime");
			return (Criteria) this;
		}

		public Criteria andMakeDateTimeLessThan(Date value) {
			addCriterion("make_date_time <", value, "makeDateTime");
			return (Criteria) this;
		}

		public Criteria andMakeDateTimeLessThanOrEqualTo(Date value) {
			addCriterion("make_date_time <=", value, "makeDateTime");
			return (Criteria) this;
		}

		public Criteria andMakeDateTimeIn(List<Date> values) {
			addCriterion("make_date_time in", values, "makeDateTime");
			return (Criteria) this;
		}

		public Criteria andMakeDateTimeNotIn(List<Date> values) {
			addCriterion("make_date_time not in", values, "makeDateTime");
			return (Criteria) this;
		}

		public Criteria andMakeDateTimeBetween(Date value1, Date value2) {
			addCriterion("make_date_time between", value1, value2,
					"makeDateTime");
			return (Criteria) this;
		}

		public Criteria andMakeDateTimeNotBetween(Date value1, Date value2) {
			addCriterion("make_date_time not between", value1, value2,
					"makeDateTime");
			return (Criteria) this;
		}

		public Criteria andDayIsNull() {
			addCriterion("day is null");
			return (Criteria) this;
		}

		public Criteria andDayIsNotNull() {
			addCriterion("day is not null");
			return (Criteria) this;
		}

		public Criteria andDayEqualTo(String value) {
			addCriterion("day =", value, "day");
			return (Criteria) this;
		}

		public Criteria andDayNotEqualTo(String value) {
			addCriterion("day <>", value, "day");
			return (Criteria) this;
		}

		public Criteria andDayGreaterThan(String value) {
			addCriterion("day >", value, "day");
			return (Criteria) this;
		}

		public Criteria andDayGreaterThanOrEqualTo(String value) {
			addCriterion("day >=", value, "day");
			return (Criteria) this;
		}

		public Criteria andDayLessThan(String value) {
			addCriterion("day <", value, "day");
			return (Criteria) this;
		}

		public Criteria andDayLessThanOrEqualTo(String value) {
			addCriterion("day <=", value, "day");
			return (Criteria) this;
		}

		public Criteria andDayLike(String value) {
			addCriterion("day like", value, "day");
			return (Criteria) this;
		}

		public Criteria andDayNotLike(String value) {
			addCriterion("day not like", value, "day");
			return (Criteria) this;
		}

		public Criteria andDayIn(List<String> values) {
			addCriterion("day in", values, "day");
			return (Criteria) this;
		}

		public Criteria andDayNotIn(List<String> values) {
			addCriterion("day not in", values, "day");
			return (Criteria) this;
		}

		public Criteria andDayBetween(String value1, String value2) {
			addCriterion("day between", value1, value2, "day");
			return (Criteria) this;
		}

		public Criteria andDayNotBetween(String value1, String value2) {
			addCriterion("day not between", value1, value2, "day");
			return (Criteria) this;
		}

		public Criteria andRedOneIsNull() {
			addCriterion("red_one is null");
			return (Criteria) this;
		}

		public Criteria andRedOneIsNotNull() {
			addCriterion("red_one is not null");
			return (Criteria) this;
		}

		public Criteria andRedOneEqualTo(Integer value) {
			addCriterion("red_one =", value, "redOne");
			return (Criteria) this;
		}

		public Criteria andRedOneNotEqualTo(Integer value) {
			addCriterion("red_one <>", value, "redOne");
			return (Criteria) this;
		}

		public Criteria andRedOneGreaterThan(Integer value) {
			addCriterion("red_one >", value, "redOne");
			return (Criteria) this;
		}

		public Criteria andRedOneGreaterThanOrEqualTo(Integer value) {
			addCriterion("red_one >=", value, "redOne");
			return (Criteria) this;
		}

		public Criteria andRedOneLessThan(Integer value) {
			addCriterion("red_one <", value, "redOne");
			return (Criteria) this;
		}

		public Criteria andRedOneLessThanOrEqualTo(Integer value) {
			addCriterion("red_one <=", value, "redOne");
			return (Criteria) this;
		}

		public Criteria andRedOneIn(List<Integer> values) {
			addCriterion("red_one in", values, "redOne");
			return (Criteria) this;
		}

		public Criteria andRedOneNotIn(List<Integer> values) {
			addCriterion("red_one not in", values, "redOne");
			return (Criteria) this;
		}

		public Criteria andRedOneBetween(Integer value1, Integer value2) {
			addCriterion("red_one between", value1, value2, "redOne");
			return (Criteria) this;
		}

		public Criteria andRedOneNotBetween(Integer value1, Integer value2) {
			addCriterion("red_one not between", value1, value2, "redOne");
			return (Criteria) this;
		}

		public Criteria andRedTwoIsNull() {
			addCriterion("red_two is null");
			return (Criteria) this;
		}

		public Criteria andRedTwoIsNotNull() {
			addCriterion("red_two is not null");
			return (Criteria) this;
		}

		public Criteria andRedTwoEqualTo(Integer value) {
			addCriterion("red_two =", value, "redTwo");
			return (Criteria) this;
		}

		public Criteria andRedTwoNotEqualTo(Integer value) {
			addCriterion("red_two <>", value, "redTwo");
			return (Criteria) this;
		}

		public Criteria andRedTwoGreaterThan(Integer value) {
			addCriterion("red_two >", value, "redTwo");
			return (Criteria) this;
		}

		public Criteria andRedTwoGreaterThanOrEqualTo(Integer value) {
			addCriterion("red_two >=", value, "redTwo");
			return (Criteria) this;
		}

		public Criteria andRedTwoLessThan(Integer value) {
			addCriterion("red_two <", value, "redTwo");
			return (Criteria) this;
		}

		public Criteria andRedTwoLessThanOrEqualTo(Integer value) {
			addCriterion("red_two <=", value, "redTwo");
			return (Criteria) this;
		}

		public Criteria andRedTwoIn(List<Integer> values) {
			addCriterion("red_two in", values, "redTwo");
			return (Criteria) this;
		}

		public Criteria andRedTwoNotIn(List<Integer> values) {
			addCriterion("red_two not in", values, "redTwo");
			return (Criteria) this;
		}

		public Criteria andRedTwoBetween(Integer value1, Integer value2) {
			addCriterion("red_two between", value1, value2, "redTwo");
			return (Criteria) this;
		}

		public Criteria andRedTwoNotBetween(Integer value1, Integer value2) {
			addCriterion("red_two not between", value1, value2, "redTwo");
			return (Criteria) this;
		}

		public Criteria andRedThreeIsNull() {
			addCriterion("red_three is null");
			return (Criteria) this;
		}

		public Criteria andRedThreeIsNotNull() {
			addCriterion("red_three is not null");
			return (Criteria) this;
		}

		public Criteria andRedThreeEqualTo(Integer value) {
			addCriterion("red_three =", value, "redThree");
			return (Criteria) this;
		}

		public Criteria andRedThreeNotEqualTo(Integer value) {
			addCriterion("red_three <>", value, "redThree");
			return (Criteria) this;
		}

		public Criteria andRedThreeGreaterThan(Integer value) {
			addCriterion("red_three >", value, "redThree");
			return (Criteria) this;
		}

		public Criteria andRedThreeGreaterThanOrEqualTo(Integer value) {
			addCriterion("red_three >=", value, "redThree");
			return (Criteria) this;
		}

		public Criteria andRedThreeLessThan(Integer value) {
			addCriterion("red_three <", value, "redThree");
			return (Criteria) this;
		}

		public Criteria andRedThreeLessThanOrEqualTo(Integer value) {
			addCriterion("red_three <=", value, "redThree");
			return (Criteria) this;
		}

		public Criteria andRedThreeIn(List<Integer> values) {
			addCriterion("red_three in", values, "redThree");
			return (Criteria) this;
		}

		public Criteria andRedThreeNotIn(List<Integer> values) {
			addCriterion("red_three not in", values, "redThree");
			return (Criteria) this;
		}

		public Criteria andRedThreeBetween(Integer value1, Integer value2) {
			addCriterion("red_three between", value1, value2, "redThree");
			return (Criteria) this;
		}

		public Criteria andRedThreeNotBetween(Integer value1, Integer value2) {
			addCriterion("red_three not between", value1, value2, "redThree");
			return (Criteria) this;
		}

		public Criteria andRedFourIsNull() {
			addCriterion("red_four is null");
			return (Criteria) this;
		}

		public Criteria andRedFourIsNotNull() {
			addCriterion("red_four is not null");
			return (Criteria) this;
		}

		public Criteria andRedFourEqualTo(Integer value) {
			addCriterion("red_four =", value, "redFour");
			return (Criteria) this;
		}

		public Criteria andRedFourNotEqualTo(Integer value) {
			addCriterion("red_four <>", value, "redFour");
			return (Criteria) this;
		}

		public Criteria andRedFourGreaterThan(Integer value) {
			addCriterion("red_four >", value, "redFour");
			return (Criteria) this;
		}

		public Criteria andRedFourGreaterThanOrEqualTo(Integer value) {
			addCriterion("red_four >=", value, "redFour");
			return (Criteria) this;
		}

		public Criteria andRedFourLessThan(Integer value) {
			addCriterion("red_four <", value, "redFour");
			return (Criteria) this;
		}

		public Criteria andRedFourLessThanOrEqualTo(Integer value) {
			addCriterion("red_four <=", value, "redFour");
			return (Criteria) this;
		}

		public Criteria andRedFourIn(List<Integer> values) {
			addCriterion("red_four in", values, "redFour");
			return (Criteria) this;
		}

		public Criteria andRedFourNotIn(List<Integer> values) {
			addCriterion("red_four not in", values, "redFour");
			return (Criteria) this;
		}

		public Criteria andRedFourBetween(Integer value1, Integer value2) {
			addCriterion("red_four between", value1, value2, "redFour");
			return (Criteria) this;
		}

		public Criteria andRedFourNotBetween(Integer value1, Integer value2) {
			addCriterion("red_four not between", value1, value2, "redFour");
			return (Criteria) this;
		}

		public Criteria andRedFiveIsNull() {
			addCriterion("red_five is null");
			return (Criteria) this;
		}

		public Criteria andRedFiveIsNotNull() {
			addCriterion("red_five is not null");
			return (Criteria) this;
		}

		public Criteria andRedFiveEqualTo(Integer value) {
			addCriterion("red_five =", value, "redFive");
			return (Criteria) this;
		}

		public Criteria andRedFiveNotEqualTo(Integer value) {
			addCriterion("red_five <>", value, "redFive");
			return (Criteria) this;
		}

		public Criteria andRedFiveGreaterThan(Integer value) {
			addCriterion("red_five >", value, "redFive");
			return (Criteria) this;
		}

		public Criteria andRedFiveGreaterThanOrEqualTo(Integer value) {
			addCriterion("red_five >=", value, "redFive");
			return (Criteria) this;
		}

		public Criteria andRedFiveLessThan(Integer value) {
			addCriterion("red_five <", value, "redFive");
			return (Criteria) this;
		}

		public Criteria andRedFiveLessThanOrEqualTo(Integer value) {
			addCriterion("red_five <=", value, "redFive");
			return (Criteria) this;
		}

		public Criteria andRedFiveIn(List<Integer> values) {
			addCriterion("red_five in", values, "redFive");
			return (Criteria) this;
		}

		public Criteria andRedFiveNotIn(List<Integer> values) {
			addCriterion("red_five not in", values, "redFive");
			return (Criteria) this;
		}

		public Criteria andRedFiveBetween(Integer value1, Integer value2) {
			addCriterion("red_five between", value1, value2, "redFive");
			return (Criteria) this;
		}

		public Criteria andRedFiveNotBetween(Integer value1, Integer value2) {
			addCriterion("red_five not between", value1, value2, "redFive");
			return (Criteria) this;
		}

		public Criteria andRedSixIsNull() {
			addCriterion("red_six is null");
			return (Criteria) this;
		}

		public Criteria andRedSixIsNotNull() {
			addCriterion("red_six is not null");
			return (Criteria) this;
		}

		public Criteria andRedSixEqualTo(Integer value) {
			addCriterion("red_six =", value, "redSix");
			return (Criteria) this;
		}

		public Criteria andRedSixNotEqualTo(Integer value) {
			addCriterion("red_six <>", value, "redSix");
			return (Criteria) this;
		}

		public Criteria andRedSixGreaterThan(Integer value) {
			addCriterion("red_six >", value, "redSix");
			return (Criteria) this;
		}

		public Criteria andRedSixGreaterThanOrEqualTo(Integer value) {
			addCriterion("red_six >=", value, "redSix");
			return (Criteria) this;
		}

		public Criteria andRedSixLessThan(Integer value) {
			addCriterion("red_six <", value, "redSix");
			return (Criteria) this;
		}

		public Criteria andRedSixLessThanOrEqualTo(Integer value) {
			addCriterion("red_six <=", value, "redSix");
			return (Criteria) this;
		}

		public Criteria andRedSixIn(List<Integer> values) {
			addCriterion("red_six in", values, "redSix");
			return (Criteria) this;
		}

		public Criteria andRedSixNotIn(List<Integer> values) {
			addCriterion("red_six not in", values, "redSix");
			return (Criteria) this;
		}

		public Criteria andRedSixBetween(Integer value1, Integer value2) {
			addCriterion("red_six between", value1, value2, "redSix");
			return (Criteria) this;
		}

		public Criteria andRedSixNotBetween(Integer value1, Integer value2) {
			addCriterion("red_six not between", value1, value2, "redSix");
			return (Criteria) this;
		}

		public Criteria andBlueIsNull() {
			addCriterion("blue is null");
			return (Criteria) this;
		}

		public Criteria andBlueIsNotNull() {
			addCriterion("blue is not null");
			return (Criteria) this;
		}

		public Criteria andBlueEqualTo(Integer value) {
			addCriterion("blue =", value, "blue");
			return (Criteria) this;
		}

		public Criteria andBlueNotEqualTo(Integer value) {
			addCriterion("blue <>", value, "blue");
			return (Criteria) this;
		}

		public Criteria andBlueGreaterThan(Integer value) {
			addCriterion("blue >", value, "blue");
			return (Criteria) this;
		}

		public Criteria andBlueGreaterThanOrEqualTo(Integer value) {
			addCriterion("blue >=", value, "blue");
			return (Criteria) this;
		}

		public Criteria andBlueLessThan(Integer value) {
			addCriterion("blue <", value, "blue");
			return (Criteria) this;
		}

		public Criteria andBlueLessThanOrEqualTo(Integer value) {
			addCriterion("blue <=", value, "blue");
			return (Criteria) this;
		}

		public Criteria andBlueIn(List<Integer> values) {
			addCriterion("blue in", values, "blue");
			return (Criteria) this;
		}

		public Criteria andBlueNotIn(List<Integer> values) {
			addCriterion("blue not in", values, "blue");
			return (Criteria) this;
		}

		public Criteria andBlueBetween(Integer value1, Integer value2) {
			addCriterion("blue between", value1, value2, "blue");
			return (Criteria) this;
		}

		public Criteria andBlueNotBetween(Integer value1, Integer value2) {
			addCriterion("blue not between", value1, value2, "blue");
			return (Criteria) this;
		}

		public Criteria andSummationValueIsNull() {
			addCriterion("summation_value is null");
			return (Criteria) this;
		}

		public Criteria andSummationValueIsNotNull() {
			addCriterion("summation_value is not null");
			return (Criteria) this;
		}

		public Criteria andSummationValueEqualTo(Integer value) {
			addCriterion("summation_value =", value, "summationValue");
			return (Criteria) this;
		}

		public Criteria andSummationValueNotEqualTo(Integer value) {
			addCriterion("summation_value <>", value, "summationValue");
			return (Criteria) this;
		}

		public Criteria andSummationValueGreaterThan(Integer value) {
			addCriterion("summation_value >", value, "summationValue");
			return (Criteria) this;
		}

		public Criteria andSummationValueGreaterThanOrEqualTo(Integer value) {
			addCriterion("summation_value >=", value, "summationValue");
			return (Criteria) this;
		}

		public Criteria andSummationValueLessThan(Integer value) {
			addCriterion("summation_value <", value, "summationValue");
			return (Criteria) this;
		}

		public Criteria andSummationValueLessThanOrEqualTo(Integer value) {
			addCriterion("summation_value <=", value, "summationValue");
			return (Criteria) this;
		}

		public Criteria andSummationValueIn(List<Integer> values) {
			addCriterion("summation_value in", values, "summationValue");
			return (Criteria) this;
		}

		public Criteria andSummationValueNotIn(List<Integer> values) {
			addCriterion("summation_value not in", values, "summationValue");
			return (Criteria) this;
		}

		public Criteria andSummationValueBetween(Integer value1, Integer value2) {
			addCriterion("summation_value between", value1, value2,
					"summationValue");
			return (Criteria) this;
		}

		public Criteria andSummationValueNotBetween(Integer value1,
				Integer value2) {
			addCriterion("summation_value not between", value1, value2,
					"summationValue");
			return (Criteria) this;
		}

		public Criteria andMedianValueIsNull() {
			addCriterion("median_value is null");
			return (Criteria) this;
		}

		public Criteria andMedianValueIsNotNull() {
			addCriterion("median_value is not null");
			return (Criteria) this;
		}

		public Criteria andMedianValueEqualTo(Integer value) {
			addCriterion("median_value =", value, "medianValue");
			return (Criteria) this;
		}

		public Criteria andMedianValueNotEqualTo(Integer value) {
			addCriterion("median_value <>", value, "medianValue");
			return (Criteria) this;
		}

		public Criteria andMedianValueGreaterThan(Integer value) {
			addCriterion("median_value >", value, "medianValue");
			return (Criteria) this;
		}

		public Criteria andMedianValueGreaterThanOrEqualTo(Integer value) {
			addCriterion("median_value >=", value, "medianValue");
			return (Criteria) this;
		}

		public Criteria andMedianValueLessThan(Integer value) {
			addCriterion("median_value <", value, "medianValue");
			return (Criteria) this;
		}

		public Criteria andMedianValueLessThanOrEqualTo(Integer value) {
			addCriterion("median_value <=", value, "medianValue");
			return (Criteria) this;
		}

		public Criteria andMedianValueIn(List<Integer> values) {
			addCriterion("median_value in", values, "medianValue");
			return (Criteria) this;
		}

		public Criteria andMedianValueNotIn(List<Integer> values) {
			addCriterion("median_value not in", values, "medianValue");
			return (Criteria) this;
		}

		public Criteria andMedianValueBetween(Integer value1, Integer value2) {
			addCriterion("median_value between", value1, value2, "medianValue");
			return (Criteria) this;
		}

		public Criteria andMedianValueNotBetween(Integer value1, Integer value2) {
			addCriterion("median_value not between", value1, value2,
					"medianValue");
			return (Criteria) this;
		}

		public Criteria andMinValueIsNull() {
			addCriterion("min_value is null");
			return (Criteria) this;
		}

		public Criteria andMinValueIsNotNull() {
			addCriterion("min_value is not null");
			return (Criteria) this;
		}

		public Criteria andMinValueEqualTo(Integer value) {
			addCriterion("min_value =", value, "minValue");
			return (Criteria) this;
		}

		public Criteria andMinValueNotEqualTo(Integer value) {
			addCriterion("min_value <>", value, "minValue");
			return (Criteria) this;
		}

		public Criteria andMinValueGreaterThan(Integer value) {
			addCriterion("min_value >", value, "minValue");
			return (Criteria) this;
		}

		public Criteria andMinValueGreaterThanOrEqualTo(Integer value) {
			addCriterion("min_value >=", value, "minValue");
			return (Criteria) this;
		}

		public Criteria andMinValueLessThan(Integer value) {
			addCriterion("min_value <", value, "minValue");
			return (Criteria) this;
		}

		public Criteria andMinValueLessThanOrEqualTo(Integer value) {
			addCriterion("min_value <=", value, "minValue");
			return (Criteria) this;
		}

		public Criteria andMinValueIn(List<Integer> values) {
			addCriterion("min_value in", values, "minValue");
			return (Criteria) this;
		}

		public Criteria andMinValueNotIn(List<Integer> values) {
			addCriterion("min_value not in", values, "minValue");
			return (Criteria) this;
		}

		public Criteria andMinValueBetween(Integer value1, Integer value2) {
			addCriterion("min_value between", value1, value2, "minValue");
			return (Criteria) this;
		}

		public Criteria andMinValueNotBetween(Integer value1, Integer value2) {
			addCriterion("min_value not between", value1, value2, "minValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueIsNull() {
			addCriterion("max_value is null");
			return (Criteria) this;
		}

		public Criteria andMaxValueIsNotNull() {
			addCriterion("max_value is not null");
			return (Criteria) this;
		}

		public Criteria andMaxValueEqualTo(Integer value) {
			addCriterion("max_value =", value, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueNotEqualTo(Integer value) {
			addCriterion("max_value <>", value, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueGreaterThan(Integer value) {
			addCriterion("max_value >", value, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueGreaterThanOrEqualTo(Integer value) {
			addCriterion("max_value >=", value, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueLessThan(Integer value) {
			addCriterion("max_value <", value, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueLessThanOrEqualTo(Integer value) {
			addCriterion("max_value <=", value, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueIn(List<Integer> values) {
			addCriterion("max_value in", values, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueNotIn(List<Integer> values) {
			addCriterion("max_value not in", values, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueBetween(Integer value1, Integer value2) {
			addCriterion("max_value between", value1, value2, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueNotBetween(Integer value1, Integer value2) {
			addCriterion("max_value not between", value1, value2, "maxValue");
			return (Criteria) this;
		}

		public Criteria andVarianceValueIsNull() {
			addCriterion("variance_value is null");
			return (Criteria) this;
		}

		public Criteria andVarianceValueIsNotNull() {
			addCriterion("variance_value is not null");
			return (Criteria) this;
		}

		public Criteria andVarianceValueEqualTo(Double value) {
			addCriterion("variance_value =", value, "varianceValue");
			return (Criteria) this;
		}

		public Criteria andVarianceValueNotEqualTo(Double value) {
			addCriterion("variance_value <>", value, "varianceValue");
			return (Criteria) this;
		}

		public Criteria andVarianceValueGreaterThan(Double value) {
			addCriterion("variance_value >", value, "varianceValue");
			return (Criteria) this;
		}

		public Criteria andVarianceValueGreaterThanOrEqualTo(Double value) {
			addCriterion("variance_value >=", value, "varianceValue");
			return (Criteria) this;
		}

		public Criteria andVarianceValueLessThan(Double value) {
			addCriterion("variance_value <", value, "varianceValue");
			return (Criteria) this;
		}

		public Criteria andVarianceValueLessThanOrEqualTo(Double value) {
			addCriterion("variance_value <=", value, "varianceValue");
			return (Criteria) this;
		}

		public Criteria andVarianceValueIn(List<Double> values) {
			addCriterion("variance_value in", values, "varianceValue");
			return (Criteria) this;
		}

		public Criteria andVarianceValueNotIn(List<Double> values) {
			addCriterion("variance_value not in", values, "varianceValue");
			return (Criteria) this;
		}

		public Criteria andVarianceValueBetween(Double value1, Double value2) {
			addCriterion("variance_value between", value1, value2,
					"varianceValue");
			return (Criteria) this;
		}

		public Criteria andVarianceValueNotBetween(Double value1, Double value2) {
			addCriterion("variance_value not between", value1, value2,
					"varianceValue");
			return (Criteria) this;
		}

		public Criteria andEValueIsNull() {
			addCriterion("e_value is null");
			return (Criteria) this;
		}

		public Criteria andEValueIsNotNull() {
			addCriterion("e_value is not null");
			return (Criteria) this;
		}

		public Criteria andEValueEqualTo(Double value) {
			addCriterion("e_value =", value, "eValue");
			return (Criteria) this;
		}

		public Criteria andEValueNotEqualTo(Double value) {
			addCriterion("e_value <>", value, "eValue");
			return (Criteria) this;
		}

		public Criteria andEValueGreaterThan(Double value) {
			addCriterion("e_value >", value, "eValue");
			return (Criteria) this;
		}

		public Criteria andEValueGreaterThanOrEqualTo(Double value) {
			addCriterion("e_value >=", value, "eValue");
			return (Criteria) this;
		}

		public Criteria andEValueLessThan(Double value) {
			addCriterion("e_value <", value, "eValue");
			return (Criteria) this;
		}

		public Criteria andEValueLessThanOrEqualTo(Double value) {
			addCriterion("e_value <=", value, "eValue");
			return (Criteria) this;
		}

		public Criteria andEValueIn(List<Double> values) {
			addCriterion("e_value in", values, "eValue");
			return (Criteria) this;
		}

		public Criteria andEValueNotIn(List<Double> values) {
			addCriterion("e_value not in", values, "eValue");
			return (Criteria) this;
		}

		public Criteria andEValueBetween(Double value1, Double value2) {
			addCriterion("e_value between", value1, value2, "eValue");
			return (Criteria) this;
		}

		public Criteria andEValueNotBetween(Double value1, Double value2) {
			addCriterion("e_value not between", value1, value2, "eValue");
			return (Criteria) this;
		}

		public Criteria andAverageValueIsNull() {
			addCriterion("average_value is null");
			return (Criteria) this;
		}

		public Criteria andAverageValueIsNotNull() {
			addCriterion("average_value is not null");
			return (Criteria) this;
		}

		public Criteria andAverageValueEqualTo(Double value) {
			addCriterion("average_value =", value, "averageValue");
			return (Criteria) this;
		}

		public Criteria andAverageValueNotEqualTo(Double value) {
			addCriterion("average_value <>", value, "averageValue");
			return (Criteria) this;
		}

		public Criteria andAverageValueGreaterThan(Double value) {
			addCriterion("average_value >", value, "averageValue");
			return (Criteria) this;
		}

		public Criteria andAverageValueGreaterThanOrEqualTo(Double value) {
			addCriterion("average_value >=", value, "averageValue");
			return (Criteria) this;
		}

		public Criteria andAverageValueLessThan(Double value) {
			addCriterion("average_value <", value, "averageValue");
			return (Criteria) this;
		}

		public Criteria andAverageValueLessThanOrEqualTo(Double value) {
			addCriterion("average_value <=", value, "averageValue");
			return (Criteria) this;
		}

		public Criteria andAverageValueIn(List<Double> values) {
			addCriterion("average_value in", values, "averageValue");
			return (Criteria) this;
		}

		public Criteria andAverageValueNotIn(List<Double> values) {
			addCriterion("average_value not in", values, "averageValue");
			return (Criteria) this;
		}

		public Criteria andAverageValueBetween(Double value1, Double value2) {
			addCriterion("average_value between", value1, value2,
					"averageValue");
			return (Criteria) this;
		}

		public Criteria andAverageValueNotBetween(Double value1, Double value2) {
			addCriterion("average_value not between", value1, value2,
					"averageValue");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table ball
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
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
     * This class corresponds to the database table ball
     *
     * @mbggenerated do_not_delete_during_merge Fri Jan 24 01:16:24 CST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}