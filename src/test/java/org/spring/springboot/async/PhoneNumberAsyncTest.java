package org.spring.springboot.async;

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
 * 从oracle导入PhoneNumber到es
 * Created by wuxiaowei on 2018/1/11
 */

//@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringBootTest(classes = Application.class)
public class PhoneNumberAsyncTest {

    @Autowired
    private PhoneNumberAsync task;

    //线程任务数
    @Value("${corePoolSize_read}")
    int countThread = 0;


    /**
     * 导入PhoneNumber
     * @throws Exception
     */
    //@Test
    public void doTaskOne() throws Exception {



        List<Future> futureList = new ArrayList<Future>();
        for (int i = 0;i < countThread;i++){
            Future<String> task1 = task.doTaskOne();
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