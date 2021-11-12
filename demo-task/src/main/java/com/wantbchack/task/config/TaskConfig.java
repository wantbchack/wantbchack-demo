//package com.wantbchack.task.config;
//
//import org.apache.commons.lang3.concurrent.BasicThreadFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.SchedulingConfigurer;
//import org.springframework.scheduling.config.ScheduledTaskRegistrar;
//
//import java.util.concurrent.Executor;
//import java.util.concurrent.ScheduledThreadPoolExecutor;
//
///**
// * @author: fanxiaobin
// * @Date: 2021/05/31/15:32
// * 感谢原作者yangkai.shen
// */
//@Configuration
//@EnableScheduling
//@ComponentScan(basePackages = {"com.wantbchack.task.job"})
//public class TaskConfig implements SchedulingConfigurer {
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
//        scheduledTaskRegistrar.setScheduler(taskExecutor());
//    }
//
//
//    /**
//     * 这里等同于配置文件配置
//     * {@code spring.task.scheduling.pool.size=20} - Maximum allowed number of threads.
//     * {@code spring.task.scheduling.thread-name-prefix=Job-Thread- } - Prefix to use for the names of newly created threads.
//     * {@link org.springframework.boot.autoconfigure.task.TaskSchedulingProperties}
//     */
//    @Bean
//    public Executor taskExecutor() {
//        return new ScheduledThreadPoolExecutor(20, new BasicThreadFactory.Builder().namingPattern("Job-Thread-%d").build());
//    }
//}
