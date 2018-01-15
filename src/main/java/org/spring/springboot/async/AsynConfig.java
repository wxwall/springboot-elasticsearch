package org.spring.springboot.async;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义异步调用（线程池配置）
 * Created by wxwall on 2017/9/4.
 */
@Configuration
@EnableAsync
public class AsynConfig {

    /** Set the ThreadPoolExecutor's core pool size. */
    @Value("${corePoolSize_read}")
    private int corePoolSize_read = 10;
    /** Set the ThreadPoolExecutor's maximum pool size. */
    @Value("${maxPoolSize_read}")
    private int maxPoolSize_read = 20;
    /** Set the capacity for the ThreadPoolExecutor's BlockingQueue. */
    @Value("${queueCapacity_read}")
    private int queueCapacity_read = 100;
    @Value("${ThreadNamePrefix_read}")
    private String ThreadNamePrefix_read = "batchExecutor-";




    //读线程池配置
    @Bean(name = "batchExecutor")
    public Executor readExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize_read);
        executor.setMaxPoolSize(maxPoolSize_read);
        executor.setQueueCapacity(queueCapacity_read);
        executor.setThreadNamePrefix(ThreadNamePrefix_read);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        executor.initialize();
        return executor;
    }




}
