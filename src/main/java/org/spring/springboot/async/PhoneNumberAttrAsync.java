package org.spring.springboot.async;

import org.spring.springboot.domain.PhoneNumberAttr;
import org.spring.springboot.domain.mybatis.PhoneNumberAttrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.spring.springboot.service.PhoneNumberAttrService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * 多线程任务
 * Created by wuxiaowei on 2018/1/11
 */
@Component
public class PhoneNumberAttrAsync {


    @Autowired
    private PhoneNumberAttrMapper PhoneNumberAttrMapper;

    @Autowired
    private PhoneNumberAttrService PhoneNumberAttrService;


    private volatile Long sum = 49648064L;

    private static Long count = 30000000L;

    //每次增加100
    private Long size = 200000L;


    @Async("batchExecutor")
    public Future<String> phoneNumberAttrTask() throws Exception {

        Long temp = 0L;


        while (true){
            synchronized (PhoneNumberAttrAsync.count){
                //保证线程之间查询数据库的表行数不重复，且始终累加
                count = count + size;
                temp = count;
            }
            System.out.println("任务"+Thread.currentThread().getName()+ "  :从"  + (temp-size) + "到" + temp);
            Long beginDBTime = System.currentTimeMillis();
            List<PhoneNumberAttr> PhoneNumberAttrs = PhoneNumberAttrMapper.findAll((temp - size),temp);
            try {
                List<PhoneNumberAttr> newPhoneNumberAttrs = new ArrayList<PhoneNumberAttr>();
                for (PhoneNumberAttr PhoneNumberAttr: PhoneNumberAttrs) {
                    PhoneNumberAttr.setId(PhoneNumberAttr.getPhone_number_id());
                    newPhoneNumberAttrs.add(PhoneNumberAttr);
                    //PhoneNumberAttrService.savePhoneNumberAttr(PhoneNumberAttr);
                }
                PhoneNumberAttrService.savePhoneNumberAttrs(newPhoneNumberAttrs);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Long endTime = System.currentTimeMillis() - beginDBTime;
            System.out.println("保存完成：" + PhoneNumberAttrs.size() + " 耗时：" + endTime);

            if(count > sum){
                break;
            }
        }
        return new AsyncResult("任务一完成");
    }


}
