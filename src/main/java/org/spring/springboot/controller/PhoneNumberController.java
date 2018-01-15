package org.spring.springboot.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiOperation;
import org.spring.springboot.domain.PhoneNumber;
import org.spring.springboot.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wuxiaowei on 01/105/2018.
 */
@RestController
public class PhoneNumberController {

    @Autowired
    private PhoneNumberService phoneNumberService;

    @ApiOperation(value="号码保存", notes="根据传过来的json保存")
    @RequestMapping(value = "/api/phoneNumber/savePhoneNumber", method = RequestMethod.POST)
    public Long savePhoneNumber(@RequestParam(value = "phoneNumberJson") String phoneNumberJson) {
        return phoneNumberService.savePhoneNumber(JSON.parseObject(phoneNumberJson, PhoneNumber.class));
    }

    @ApiOperation(value="号码条件查询", notes="根据传过来的条件查询")
    @RequestMapping(value = "/api/phoneNumber/search", method = RequestMethod.POST)
    public List<PhoneNumber> searchPhone(@RequestParam(value = "pageNumber") Integer pageNumber,
                                         @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                         @RequestParam(value = "searchContent") String searchContent) {
        PhoneNumber phoneNumber = null;
        try {
            phoneNumber = JSON.parseObject(searchContent, PhoneNumber.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return phoneNumberService.searchPhoneNumber(pageNumber, pageSize, phoneNumber);
    }


    @ApiOperation(value="号码id查询", notes="根据传过来id条件查询")
    @RequestMapping(value = "/api/phoneNumber/findOnePhoneNumber", method = RequestMethod.POST)
    public PhoneNumber findOnePhoneNumber(@RequestParam(value = "id") Long id) throws Exception {

        return phoneNumberService.findOne(id);
    }


}
