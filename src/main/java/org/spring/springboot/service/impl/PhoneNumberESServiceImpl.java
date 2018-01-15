package org.spring.springboot.service.impl;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.domain.PhoneNumber;
import org.spring.springboot.repository.PhoneNumberRepository;
import org.spring.springboot.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wuxiaowei on 2018/1/10
 */
@Service
public class PhoneNumberESServiceImpl implements PhoneNumberService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhoneNumberESServiceImpl.class);

    @Autowired
    PhoneNumberRepository PhoneNumberRepository;


    @Override
    public Long savePhoneNumber(PhoneNumber phoneNumber) {
        PhoneNumber save = PhoneNumberRepository.save(phoneNumber);
        return save.getPhone_number_id();
    }


    public PhoneNumber findOne(Long id) throws Exception{
        return PhoneNumberRepository.findOne(id);
    }

    @Override
    public List<PhoneNumber> searchPhoneNumber(Integer pageNumber, Integer pageSize, PhoneNumber pn) {
        // 分页参数
        Pageable pageable = new PageRequest(pageNumber, pageSize);

        //Query
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if(pn.getStatus_cd() != null){
            boolQueryBuilder.must(QueryBuilders.termQuery("status_cd", pn.getStatus_cd()));
        }
        if(pn.getProvince_id() != null){
            boolQueryBuilder.must(QueryBuilders.termQuery("province_id", pn.getProvince_id()));
        }
        if(pn.getArea_id() != null){
            boolQueryBuilder.must(QueryBuilders.termQuery("AREA_ID", pn.getArea_id()));
        }
        if(pn.getPool_id() != null){
            boolQueryBuilder .must(QueryBuilders.termQuery("pool_id", pn.getPool_id()));//  (PN.POOL_ID IN (:4))  QueryBuilders.termsQuery("user", new ArrayList<String>().add("kimchy"));
        }
        if(pn.getPhone_number() != null){
            //TODO 细节处还需要商量
            boolQueryBuilder.must(QueryBuilders.regexpQuery("phone_number", "199.*.48"));//   177****6688
        }
        boolQueryBuilder.must(QueryBuilders.rangeQuery("pre_store_price").gte(0).lte(1000)); //0<= PRE_STORE_PRICE <= 1000






        // 创建搜索 DSL 查询
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(boolQueryBuilder).build();

        LOGGER.info("\n searchCity(): searchContent [" + pn.toString() + "] \n DSL  = \n " + searchQuery.getQuery().toString());
        Long begin = System.currentTimeMillis();
        Page<PhoneNumber> searchPageResults = PhoneNumberRepository.search(searchQuery);
        LOGGER.info("查询ES接口耗时：" + (System.currentTimeMillis() - begin));
        return searchPageResults.getContent();
    }

    @Override
    public boolean savePhoneNumbers(List<PhoneNumber> phoneNumbers) throws Exception {
        PhoneNumberRepository.save(phoneNumbers);
        return true;
    }
}
