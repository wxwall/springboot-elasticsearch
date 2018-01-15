package org.spring.springboot.async;

import org.junit.Test;
import org.spring.springboot.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 *
 * 从oracle导入phoneNumberAttr表到es
 * Created by wuxiaowei on 2018/1/12
 */

//@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringBootTest(classes = Application.class)
public class PhoneNumberAttrAsyncTest {



    @Autowired
    private PhoneNumberAttrAsync task;

    @Value("${corePoolSize_read}")
    int countThread = 0;


    /**
     * 导入phoneNumberAttr表到es
     * @throws Exception
     */
    @Test
    public void phoneNumberAttrTask() throws Exception {


        List<Future> futureList = new ArrayList<Future>();
        for (int i = 0;i < countThread;i++){
            Future<String> task1 = task.phoneNumberAttrTask();
            Thread.sleep(1000);
            futureList.add(task1);
        }

        for (Future future : futureList){
            while (true){
                if(future.isDone()){
                    Thread.sleep(5000);
                    System.out.println(future.getClass());
                }
            }

        }

    }

}