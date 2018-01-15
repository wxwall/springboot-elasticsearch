package org.spring.springboot.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiOperation;
import org.spring.springboot.domain.PhoneNumberAttr;
import org.spring.springboot.service.PhoneNumberAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 号码属性
 * Created by wuxiaowei on 01/10/2018.
 */
@RestController
public class PhoneNumberAttrController {

    @Autowired
    private PhoneNumberAttrService phoneNumberAttrService;



    @ApiOperation(value="号码属性详情列表查询", notes="根据条件查询号码在es中的数据")
    @RequestMapping(value = "/api/phoneNumberAttr/search", method = RequestMethod.POST)
    public List<PhoneNumberAttr> searchPhone(@RequestParam(value = "pageNumber") Integer pageNumber,
                                             @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                             @RequestParam(value = "searchContent") String searchContent) {
        return phoneNumberAttrService.searchPhoneNumberAttr(pageNumber,pageSize,searchContent);
    }


    @ApiOperation(value="号码属性查询", notes="根据AttrSpecId查询属性中的记录")
    @RequestMapping(value = "/api/phoneNumberAttr/updateAttrSpecIdById", method = RequestMethod.POST)
    public boolean updateAttrSpecIdById(@RequestParam(value = "attrSpecId") String attrSpecId,
                                       @RequestParam(value = "PhoneNumberId") Long PhoneNumberId){
        try {
            return phoneNumberAttrService.updateAttrSpecIdById(attrSpecId, PhoneNumberId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @ApiOperation(value="保存号码属性", notes="传过来的拼装好的号码属性json")
    @RequestMapping(value = "/api/phoneNumberAttr/saveAttrSpec", method = RequestMethod.POST)
    public Long saveAttrSpec(@RequestParam(value = "attrSpecJson") String attrSpecJson){
        try {
            PhoneNumberAttr phoneNumberAttr = JSON.parseObject(attrSpecJson, PhoneNumberAttr.class);
            return phoneNumberAttrService.savePhoneNumberAttr(phoneNumberAttr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
