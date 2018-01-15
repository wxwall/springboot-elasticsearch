package org.spring.springboot.domain.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.spring.springboot.domain.PhoneNumber;

import java.util.List;

@Mapper
public interface PhoneNumberMapper {

    @Select("SELECT * FROM crm_lte_2.PHONE_NUMBER_BAK  WHERE phone_number_id = #{id}")
    PhoneNumber findById(@Param("id") Long id);

    @Select(
            "SELECT *\n" +
            "  FROM (SELECT A.*, ROWNUM RN\n" +
            "          FROM (SELECT * FROM crm_lte_2.PHONE_NUMBER_BAK i) A\n" +
            "         WHERE ROWNUM <= #{endLine})\n" +
            " WHERE RN >= #{startLine}")
    List<PhoneNumber> findAll(@Param("startLine") Long startLine,@Param("endLine")Long endLine);
}