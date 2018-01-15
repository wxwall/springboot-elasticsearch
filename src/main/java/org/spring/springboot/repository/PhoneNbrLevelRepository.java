package org.spring.springboot.repository;

import org.spring.springboot.domain.PhoneNbrLevel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wuxiaowei on 01/10/2018.
 */
@Repository
public interface PhoneNbrLevelRepository extends ElasticsearchRepository<PhoneNbrLevel,Long> {


}
