package com.flt.dao.client;

import com.flt.dao.model.Business;
import com.flt.dao.model.BusinessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusinessMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_business
     *
     * @mbggenerated Sat Dec 05 11:14:55 CST 2015
     */
    int countByExample(BusinessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_business
     *
     * @mbggenerated Sat Dec 05 11:14:55 CST 2015
     */
    int deleteByExample(BusinessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_business
     *
     * @mbggenerated Sat Dec 05 11:14:55 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_business
     *
     * @mbggenerated Sat Dec 05 11:14:55 CST 2015
     */
    int insert(Business record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_business
     *
     * @mbggenerated Sat Dec 05 11:14:55 CST 2015
     */
    int insertSelective(Business record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_business
     *
     * @mbggenerated Sat Dec 05 11:14:55 CST 2015
     */
    List<Business> selectByExample(BusinessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_business
     *
     * @mbggenerated Sat Dec 05 11:14:55 CST 2015
     */
    Business selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_business
     *
     * @mbggenerated Sat Dec 05 11:14:55 CST 2015
     */
    int updateByExampleSelective(@Param("record") Business record, @Param("example") BusinessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_business
     *
     * @mbggenerated Sat Dec 05 11:14:55 CST 2015
     */
    int updateByExample(@Param("record") Business record, @Param("example") BusinessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_business
     *
     * @mbggenerated Sat Dec 05 11:14:55 CST 2015
     */
    int updateByPrimaryKeySelective(Business record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_business
     *
     * @mbggenerated Sat Dec 05 11:14:55 CST 2015
     */
    int updateByPrimaryKey(Business record);
}