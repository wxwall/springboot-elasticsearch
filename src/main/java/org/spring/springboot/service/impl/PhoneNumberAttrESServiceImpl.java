package org.spring.springboot.service.impl;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.domain.PhoneNumberAttr;
import org.spring.springboot.repository.PhoneNumberAttrRepository;
import org.spring.springboot.service.PhoneNumberAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wuxiaowei on 2018/1/11
 */
@Service
public class PhoneNumberAttrESServiceImpl implements PhoneNumberAttrService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityESServiceImpl.class);

    @Autowired
    PhoneNumberAttrRepository phoneNumberAttrRepository;



    @Override
    public List<PhoneNumberAttr> searchPhoneNumberAttr(Integer pageNumber, Integer pageSize, String searchContent) {
        // 分页参数
        Pageable pageable = new PageRequest(pageNumber, pageSize);

        // Query
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery()
                .must(QueryBuilders.termQuery("attr_spec_id", searchContent));


        // 创建搜索 DSL 查询
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(queryBuilder).build();

        LOGGER.info("\n searchPhoneNumberAttr(): searchContent [" + searchContent + "] \n DSL  = \n " + searchQuery.getQuery().toString());

        Page<PhoneNumberAttr> searchPageResults = phoneNumberAttrRepository.search(searchQuery);
        return searchPageResults.getContent();
    }

    @Override
    public boolean savePhoneNumberAttrs(List<PhoneNumberAttr> phoneNumberAttrs) throws Exception {
        phoneNumberAttrRepository.save(phoneNumberAttrs);
        return true;
    }

    @Override
    public boolean updateAttrSpecIdById(String attrSpecId, Long PhoneNumberId) throws Exception {
        if(PhoneNumberId == null){
            throw new RuntimeException("PhoneNumberId入参不能为空！");
        }
        PhoneNumberAttr phoneNumberAttr = phoneNumberAttrRepository.findOne(PhoneNumberId);
        phoneNumberAttr.setAttr_spec_id(attrSpecId);
        phoneNumberAttrRepository.save(phoneNumberAttr);
        return true;
    }

    @Override
    public Long savePhoneNumberAttr(PhoneNumberAttr phoneNumberAttr) {
        PhoneNumberAttr numberAttr = phoneNumberAttrRepository.save(phoneNumberAttr);
        return numberAttr.getPhone_number_id();
    }
}
