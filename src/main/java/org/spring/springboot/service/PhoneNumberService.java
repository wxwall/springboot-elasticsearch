
package org.spring.springboot.service;

import org.spring.springboot.domain.PhoneNumber;

import java.util.List;

public interface PhoneNumberService {

    /**
     * 新增
     *
     * @param phoneNumber
     * @return
     */
    Long savePhoneNumber(PhoneNumber phoneNumber);

    /**
     * 根据关键词，function score query 权重分分页查询
     *
     * @param pageNumber
     * @param pageSize
     * @param searchContent
     * @return
     */
    List<PhoneNumber> searchPhoneNumber(Integer pageNumber, Integer pageSize, PhoneNumber searchContent);


    /**
     * 批量保存
     * @param phoneNumbers
     * @return
     */
    boolean savePhoneNumbers(List<PhoneNumber> phoneNumbers) throws Exception;

    /**
     * 查询单个
     * @param id
     * @return
     * @throws Exception
     */
    PhoneNumber findOne(Long id) throws Exception;


}