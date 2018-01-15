package org.spring.springboot.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.springboot.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by wuxiaowei on 2018/1/12
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringBootTest(classes = Application.class)
public class PhoneNumberAttrControllerTest {


    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();//建议使用这种
    }


    @Test
    public void phoneNumberAttr() throws Exception {
        String pageNumber = "0";
        String pageSize = "10";
        String searchContent = "60030001";
        Long begin = System.currentTimeMillis();
        mvc.perform(MockMvcRequestBuilders
                .post("/api/phoneNumberAttr/search")
                .param("pageNumber",pageNumber)
                .param("pageSize",pageSize)
                .param("searchContent",searchContent)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void updateAttrSpecIdById() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .post("/api/phoneNumberAttr/updateAttrSpecIdById")
                .param("attrSpecId","60030002")
                .param("PhoneNumberId","521050436427")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andDo(print());
    }




    @Test
    public void saveAttrSpec() throws Exception {
        String attrSpecJson = "{\n" +
                "        \"attr_spec_id\": \"60030001\",\n" +
                "        \"create_date\": 1461254400000,\n" +
                "        \"id\": 521029183291,\n" +
                "        \"phone_number_id\": 521029183291,\n" +
                "        \"update_date\": 1461254400000\n" +
                "    }";
        mvc.perform(MockMvcRequestBuilders
                .post("/api/phoneNumberAttr/saveAttrSpec")
                .param("attrSpecJson",attrSpecJson)
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andDo(print());
    }

}