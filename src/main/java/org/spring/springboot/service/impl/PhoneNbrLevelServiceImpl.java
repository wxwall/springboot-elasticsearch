package org.spring.springboot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.domain.PhoneNbrLevel;
import org.spring.springboot.service.PhoneNbrLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.spring.springboot.repository.PhoneNbrLevelRepository;

import java.util.List;

/**
 * Created by wuxiaowei on 2018/1/11
 */
@Service
public class PhoneNbrLevelServiceImpl implements PhoneNbrLevelService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityESServiceImpl.class);

    @Autowired
    PhoneNbrLevelRepository PhoneNbrLevelRepository;



    @Override
    public List<PhoneNbrLevel> searchPhoneNbrLevel(Integer pageNumber, Integer pageSize, String searchContent) {
        return null;
    }

    @Override
    public boolean savePhoneNbrLevels(List<PhoneNbrLevel> PhoneNbrLevels) throws Exception {
        PhoneNbrLevelRepository.save(PhoneNbrLevels);
        return true;
    }

    @Override
    public void save(PhoneNbrLevel phoneNbrLevel) {
        PhoneNbrLevelRepository.save(phoneNbrLevel);
    }
}
