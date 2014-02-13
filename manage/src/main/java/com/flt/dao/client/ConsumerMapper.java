package com.flt.dao.client;

import com.flt.dao.model.Consumer;
import com.flt.dao.model.ConsumerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConsumerMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table consumer
	 * @mbggenerated  Mon Feb 03 17:00:19 CST 2014
	 */
	int countByExample(ConsumerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table consumer
	 * @mbggenerated  Mon Feb 03 17:00:19 CST 2014
	 */
	int deleteByExample(ConsumerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table consumer
	 * @mbggenerated  Mon Feb 03 17:00:19 CST 2014
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table consumer
	 * @mbggenerated  Mon Feb 03 17:00:19 CST 2014
	 */
	int insert(Consumer record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table consumer
	 * @mbggenerated  Mon Feb 03 17:00:19 CST 2014
	 */
	int insertSelective(Consumer record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table consumer
	 * @mbggenerated  Mon Feb 03 17:00:19 CST 2014
	 */
	List<Consumer> selectByExample(ConsumerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table consumer
	 * @mbggenerated  Mon Feb 03 17:00:19 CST 2014
	 */
	Consumer selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table consumer
	 * @mbggenerated  Mon Feb 03 17:00:19 CST 2014
	 */
	int updateByExampleSelective(@Param("record") Consumer record,
			@Param("example") ConsumerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table consumer
	 * @mbggenerated  Mon Feb 03 17:00:19 CST 2014
	 */
	int updateByExample(@Param("record") Consumer record,
			@Param("example") ConsumerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table consumer
	 * @mbggenerated  Mon Feb 03 17:00:19 CST 2014
	 */
	int updateByPrimaryKeySelective(Consumer record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table consumer
	 * @mbggenerated  Mon Feb 03 17:00:19 CST 2014
	 */
	int updateByPrimaryKey(Consumer record);
}