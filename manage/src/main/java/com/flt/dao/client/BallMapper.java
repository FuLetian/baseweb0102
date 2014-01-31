package com.flt.dao.client;

import com.flt.dao.model.Ball;
import com.flt.dao.model.BallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BallMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ball
	 * @mbggenerated  Thu Jan 30 00:55:21 CST 2014
	 */
	int countByExample(BallExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ball
	 * @mbggenerated  Thu Jan 30 00:55:21 CST 2014
	 */
	int deleteByExample(BallExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ball
	 * @mbggenerated  Thu Jan 30 00:55:21 CST 2014
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ball
	 * @mbggenerated  Thu Jan 30 00:55:21 CST 2014
	 */
	int insert(Ball record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ball
	 * @mbggenerated  Thu Jan 30 00:55:21 CST 2014
	 */
	int insertSelective(Ball record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ball
	 * @mbggenerated  Thu Jan 30 00:55:21 CST 2014
	 */
	List<Ball> selectByExample(BallExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ball
	 * @mbggenerated  Thu Jan 30 00:55:21 CST 2014
	 */
	Ball selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ball
	 * @mbggenerated  Thu Jan 30 00:55:21 CST 2014
	 */
	int updateByExampleSelective(@Param("record") Ball record,
			@Param("example") BallExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ball
	 * @mbggenerated  Thu Jan 30 00:55:21 CST 2014
	 */
	int updateByExample(@Param("record") Ball record,
			@Param("example") BallExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ball
	 * @mbggenerated  Thu Jan 30 00:55:21 CST 2014
	 */
	int updateByPrimaryKeySelective(Ball record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ball
	 * @mbggenerated  Thu Jan 30 00:55:21 CST 2014
	 */
	int updateByPrimaryKey(Ball record);
}