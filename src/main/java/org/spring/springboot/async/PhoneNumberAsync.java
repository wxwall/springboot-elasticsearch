package org.spring.springboot.async;

import org.spring.springboot.domain.PhoneNumber;
import org.spring.springboot.domain.mybatis.PhoneNumberMapper;
import org.spring.springboot.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * 多线程任务
 * Created by wuxiaowei on 2018/1/11
 */
@Component
public class PhoneNumberAsync {


    @Autowired
    private PhoneNumberMapper phoneNumberMapper;

    @Autowired
    private PhoneNumberService phoneNumberService;


    private volatile Long sum = 55732432L;

    private static Long count = 24670000L;

    //每次增加100
    private Long size = 50000L;


    @Async("batchExecutor")
    public Future<String> doTaskOne() throws Exception {

        Long temp = 0L;


        while (true){
            synchronized (PhoneNumberAsync.count){
                //保证线程之间查询数据库的表行数不重复，且始终累加
                count = count + size;
                temp = count;
            }
            System.out.println("任务"+Thread.currentThread().getName()+ "  :从"  + (temp-size) + "到" + temp);
            Long beginDBTime = System.currentTimeMillis();
            List<PhoneNumber> phoneNumbers = phoneNumberMapper.findAll((temp - size),temp);
            try {
                List<PhoneNumber> newPhoneNumbers = new ArrayList<PhoneNumber>();
                for (PhoneNumber phoneNumber: phoneNumbers) {
                    phoneNumber.setId(phoneNumber.getPhone_number_id());
                    newPhoneNumbers.add(phoneNumber);
                    //phoneNumberService.savePhoneNumber(phoneNumber);
                }
                phoneNumberService.savePhoneNumbers(newPhoneNumbers);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Long endTime = System.currentTimeMillis() - beginDBTime;
            System.out.println("保存完成：" + phoneNumbers.size() + " 耗时：" + endTime);

            if(count > sum){
                break;
            }
        }
        return new AsyncResult("任务一完成");
    }


}
