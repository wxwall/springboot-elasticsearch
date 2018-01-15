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
public class PhoneNumberControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();//建议使用这种
    }


    @Test
    public void searchPhone() throws Exception {
        String pageNumber = "0";
        String pageSize = "10";
        String searchContent = "{\n" +
                "    \"area_id\": \"8320100\",\n" +
                "    \"phone_number\": \"17705177167\",\n" +
                "    \"pn_level_id\": 133,\n" +
                "    \"pool_id\": 8320100,\n" +
                "    \"pre_store_price\": 0,\n" +
                "    \"province_id\": 8320000,\n" +
                "    \"status_cd\": \"1005\"\n" +
                "}";
        mvc.perform(MockMvcRequestBuilders
                .post("/api/phoneNumber/search",pageNumber,pageSize,searchContent)
                .param("pageNumber",pageNumber)
                .param("pageSize",pageSize)
                .param("searchContent",searchContent)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    public void findOnePhoneNumber() throws Exception {
        String id = "7615658";
        mvc.perform(MockMvcRequestBuilders
                .post("/api/phoneNumber/findOnePhoneNumber").param("id",id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void savePhoneNumber() throws Exception {
        String phoneNumberJson = "{\n" +
                "        \"description\": \"ESS号码分配\",\n" +
                "        \"id\": 521049727538,\n" +
                "        \"phone_number\": \"19951744448\",\n" +
                "        \"phone_number_id\": 521049727538,\n" +
                "        \"pn_character_id\": 180,\n" +
                "        \"pn_level_id\": 134,\n" +
                "        \"pn_low_price\": 49,\n" +
                "        \"pn_type_id\": 4,\n" +
                "        \"pool_id\": 11073,\n" +
                "        \"pre_store_price\": 200,\n" +
                "        \"province_id\": 8320000,\n" +
                "        \"reseller_id\": 1,\n" +
                "        \"status_cd\": \"1099\",\n" +
                "        \"upDate_date\": 1514908800000,\n" +
                "        \"with_nbr\": \"1\"\n" +
                "    }";
        mvc.perform(MockMvcRequestBuilders
                .post("/api/phoneNumber/savePhoneNumber").param("phoneNumberJson",phoneNumberJson)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }




}