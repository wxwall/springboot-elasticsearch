package org.spring.springboot.repository;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.Application;
import org.spring.springboot.domain.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wuxiaowei on 2018/1/11
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringBootTest(classes = Application.class)
public class PhoneNumberRepositoryTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhoneNumberRepositoryTest.class);

    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    @Test
    public void search(){

        int pageNumber = 1;

        int pageSize = 10;

        String searchContent = "17705175854";

        // 分页参数
        Pageable pageable = new PageRequest(pageNumber, pageSize);


        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
                .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("phone_number", searchContent)),
                        ScoreFunctionBuilders.weightFactorFunction(1000))
                .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("description", searchContent)),
                        ScoreFunctionBuilders.weightFactorFunction(100));

        // 创建搜索 DSL 查询
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder).build();
        Page<PhoneNumber> searchResult = phoneNumberRepository.search(searchQuery);
        LOGGER.info("phoneNumber 查询出结果：" + searchResult.getSize());

    }


}