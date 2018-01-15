package org.spring.springboot.domain.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.springboot.Application;
import org.spring.springboot.domain.PhoneNumberAttr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wuxiaowei on 2018/1/11
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringBootTest(classes = Application.class)
public class PhoneNumberAttrMapperTest {


    @Autowired
    private PhoneNumberAttrMapper  phoneNumberAttrMapper;



    @Test
    public void findAll() throws Exception {
        List<PhoneNumberAttr> phoneNumberList = phoneNumberAttrMapper.findAll(1L, 10L);
        for (int i = 0; i < phoneNumberList.size() ; i++) {
            System.out.println(phoneNumberList.toString());
        }



    }

}