package org.spring.springboot.domain.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.springboot.Application;
import org.spring.springboot.domain.PhoneNbrLevel;
import org.spring.springboot.repository.PhoneNbrLevelRepository;
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
public class PhoneNbrLevelMapperTest {


    @Autowired
    PhoneNbrLevelMapper phoneNbrLevelMapper;


    @Autowired
    PhoneNbrLevelRepository phoneNbrLevelRepository;

    @Test
    public void findAll() throws Exception {
        List<PhoneNbrLevel> phoneNbrLevels = phoneNbrLevelMapper.findAll(0L, 375L);
        for (PhoneNbrLevel phoneNbrLevel : phoneNbrLevels) {
            System.out.println(phoneNbrLevel.toString());
        }
    }

}