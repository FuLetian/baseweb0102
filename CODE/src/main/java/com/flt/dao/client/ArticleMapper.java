package com.flt.dao.client;

import com.flt.dao.model.Article;
import com.flt.dao.model.ArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	int countByExample(ArticleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	int deleteByExample(ArticleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	int insert(Article record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	int insertSelective(Article record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	List<Article> selectByExampleWithBLOBs(ArticleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	List<Article> selectByExample(ArticleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	Article selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	int updateByExampleSelective(@Param("record") Article record,
			@Param("example") ArticleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	int updateByExampleWithBLOBs(@Param("record") Article record,
			@Param("example") ArticleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	int updateByExample(@Param("record") Article record,
			@Param("example") ArticleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	int updateByPrimaryKeySelective(Article record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	int updateByPrimaryKeyWithBLOBs(Article record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article
	 * @mbggenerated  Sat Feb 01 21:15:19 CST 2014
	 */
	int updateByPrimaryKey(Article record);
}