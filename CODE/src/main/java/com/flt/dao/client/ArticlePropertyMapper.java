package com.flt.dao.client;

import com.flt.dao.model.ArticleProperty;
import com.flt.dao.model.ArticlePropertyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticlePropertyMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_property
	 * @mbggenerated  Mon Feb 03 16:44:14 CST 2014
	 */
	int countByExample(ArticlePropertyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_property
	 * @mbggenerated  Mon Feb 03 16:44:14 CST 2014
	 */
	int deleteByExample(ArticlePropertyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_property
	 * @mbggenerated  Mon Feb 03 16:44:14 CST 2014
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_property
	 * @mbggenerated  Mon Feb 03 16:44:14 CST 2014
	 */
	int insert(ArticleProperty record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_property
	 * @mbggenerated  Mon Feb 03 16:44:14 CST 2014
	 */
	int insertSelective(ArticleProperty record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_property
	 * @mbggenerated  Mon Feb 03 16:44:14 CST 2014
	 */
	List<ArticleProperty> selectByExample(ArticlePropertyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_property
	 * @mbggenerated  Mon Feb 03 16:44:14 CST 2014
	 */
	ArticleProperty selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_property
	 * @mbggenerated  Mon Feb 03 16:44:14 CST 2014
	 */
	int updateByExampleSelective(@Param("record") ArticleProperty record,
			@Param("example") ArticlePropertyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_property
	 * @mbggenerated  Mon Feb 03 16:44:14 CST 2014
	 */
	int updateByExample(@Param("record") ArticleProperty record,
			@Param("example") ArticlePropertyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_property
	 * @mbggenerated  Mon Feb 03 16:44:14 CST 2014
	 */
	int updateByPrimaryKeySelective(ArticleProperty record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_property
	 * @mbggenerated  Mon Feb 03 16:44:14 CST 2014
	 */
	int updateByPrimaryKey(ArticleProperty record);
}