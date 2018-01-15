package org.spring.springboot.service;

import org.spring.springboot.domain.PhoneNbrLevel;

import java.util.List;

/**
 * Created by wuxiaowei on 2018/1/11
 */
public interface PhoneNbrLevelService {


    /**
     * 根据关键词，function score query 权重分分页查询
     *
     * @param pageNumber
     * @param pageSize
     * @param searchContent
     * @return
     */
    List<PhoneNbrLevel> searchPhoneNbrLevel(Integer pageNumber, Integer pageSize, String searchContent);


    /**
     * 批量保存
     * @param PhoneNbrLevels
     * @return
     */
    boolean savePhoneNbrLevels(List<PhoneNbrLevel> PhoneNbrLevels) throws Exception;


    void save(PhoneNbrLevel phoneNbrLevel);
}
