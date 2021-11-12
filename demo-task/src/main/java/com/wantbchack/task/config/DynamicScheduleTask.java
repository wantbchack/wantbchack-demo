package com.wantbchack.task.config;

import com.wantbchack.task.entity.Cron;
import com.wantbchack.task.repository.CronRepository;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @author: fanxiaobin
 * @Date: 2021/11/12/9:46
 */
@Component
@EnableScheduling
@ComponentScan(basePackages = {"com.wantbchack.task.job"})
public class DynamicScheduleTask implements SchedulingConfigurer {

    @Autowired
    private CronRepository cronRepository;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
            taskRegistrar.setScheduler(taskExecutor());
            taskRegistrar.addTriggerTask(
                    ()-> System.out.println("执行动态定时任务: " + LocalDateTime.now().toLocalTime()),
                    triggerContext -> {
                        Cron cron = cronRepository.findByCronId(1);
                        return  new CronTrigger(cron.getCron()).nextExecutionTime(triggerContext);
                    }
            );
    }

    /**
     * 这里等同于配置文件配置
     * {@code spring.task.scheduling.pool.size=20} - Maximum allowed number of threads.
     * {@code spring.task.scheduling.thread-name-prefix=Job-Thread- } - Prefix to use for the names of newly created threads.
     * {@link org.springframework.boot.autoconfigure.task.TaskSchedulingProperties}
     */
    @Bean
    public Executor taskExecutor() {
        return new ScheduledThreadPoolExecutor(20, new BasicThreadFactory.Builder().namingPattern("Job-Thread-%d").build());
    }
}
