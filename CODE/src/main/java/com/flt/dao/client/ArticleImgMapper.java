package com.flt.dao.client;

import com.flt.dao.model.ArticleImg;
import com.flt.dao.model.ArticleImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleImgMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_img
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	int countByExample(ArticleImgExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_img
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	int deleteByExample(ArticleImgExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_img
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_img
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	int insert(ArticleImg record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_img
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	int insertSelective(ArticleImg record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_img
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	List<ArticleImg> selectByExample(ArticleImgExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_img
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	ArticleImg selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_img
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	int updateByExampleSelective(@Param("record") ArticleImg record,
			@Param("example") ArticleImgExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_img
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	int updateByExample(@Param("record") ArticleImg record,
			@Param("example") ArticleImgExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_img
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	int updateByPrimaryKeySelective(ArticleImg record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_img
	 * @mbggenerated  Tue Feb 18 14:27:14 CST 2014
	 */
	int updateByPrimaryKey(ArticleImg record);
}