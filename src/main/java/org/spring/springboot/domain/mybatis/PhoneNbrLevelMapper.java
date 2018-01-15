package org.spring.springboot.domain.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.spring.springboot.domain.PhoneNbrLevel;
import org.spring.springboot.domain.PhoneNumberAttr;

import java.util.List;

@Mapper
public interface PhoneNbrLevelMapper {

    @Select("SELECT * FROM crm_lte_2.PHONE_NBR_LEVEL_BAK  WHERE pn_level_id = #{id}")
    PhoneNumberAttr findById(@Param("id") Long id);

    @Select(
            "SELECT *\n" +
                    "  FROM (SELECT A.*, ROWNUM RN\n" +
                    "          FROM (SELECT * FROM crm_lte_2.PHONE_NBR_LEVEL_BAK i) A\n" +
                    "         WHERE ROWNUM <= #{endLine})\n" +
                    " WHERE RN >= #{startLine}")
    List<PhoneNbrLevel> findAll(@Param("startLine") Long startLine, @Param("endLine")Long endLine);
}