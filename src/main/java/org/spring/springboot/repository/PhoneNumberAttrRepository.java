package org.spring.springboot.repository;

import org.spring.springboot.domain.PhoneNumberAttr;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wuxiaowei on 01/10/2018.
 */
@Repository
public interface PhoneNumberAttrRepository extends ElasticsearchRepository<PhoneNumberAttr,Long> {


}
