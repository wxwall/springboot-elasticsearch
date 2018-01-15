package org.spring.springboot.service;

import org.spring.springboot.domain.PhoneNumberAttr;

import java.util.List;

/**
 * Created by wuxiaowei on 2018/1/11
 */
public interface PhoneNumberAttrService {


    /**
     * 根据关键词，function score query 权重分分页查询
     *
     * @param pageNumber
     * @param pageSize
     * @param searchContent
     * @return
     */
    List<PhoneNumberAttr> searchPhoneNumberAttr(Integer pageNumber, Integer pageSize, String searchContent);


    /**
     * 批量保存
     * @param phoneNumberAttrs
     * @return
     */
    boolean savePhoneNumberAttrs(List<PhoneNumberAttr> phoneNumberAttrs) throws Exception;


    /**
     * 根据PhoneNumberId来更新attrSpecId
     * @param attrSpecId
     * @param PhoneNumberId
     * @return
     */
    boolean updateAttrSpecIdById(String attrSpecId,Long PhoneNumberId) throws Exception;

    /**
     * 保存PhoneNumberAttr
     * @param phoneNumberAttr
     * @return
     */
    Long savePhoneNumberAttr(PhoneNumberAttr phoneNumberAttr);
}
