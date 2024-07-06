package io.github.loulangogogo.config;

import io.gitee.loulan_yxq.owner.core.tool.IdTool;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

@Configuration
@EnableScheduling
public class TestConfiguration {

    @Autowired
    private Scheduler scheduler;

//    @PostConstruct
    public void test() throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(IdTool.simpleUUID());
        JobDetail jobDetail = JobBuilder.newJob(TestJob.class)
                .withIdentity(jobKey)
                .build();

        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(TriggerKey.triggerKey(jobKey.getName(), jobKey.getGroup()))
                .withSchedule(CronScheduleBuilder
                        .cronSchedule("0/3 * * * * ?")
                        .withMisfireHandlingInstructionDoNothing()
                )
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
    }

//    @PostConstruct
    public void test01() throws SchedulerException {
        JobKey jobKey = JobKey.jobKey("simple"+IdTool.simpleUUID());
        JobDetail jobDetail = JobBuilder.newJob(TestJob.class)
                .withIdentity(jobKey)
                .build();

        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(TriggerKey.triggerKey(jobKey.getName(), jobKey.getGroup()))
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(3)
                                .repeatForever()
                                .withMisfireHandlingInstructionFireNow()
                ).build();

        scheduler.scheduleJob(jobDetail, trigger);
    }

    @PostConstruct
    public void test02() throws SchedulerException {
        JobKey jobKey = JobKey.jobKey("Calendar"+IdTool.simpleUUID());
        JobDetail jobDetail = JobBuilder.newJob(TestJob.class)
                .withIdentity(jobKey)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(TriggerKey.triggerKey(jobKey.getName(), jobKey.getGroup()))
                .withSchedule(
                        CalendarIntervalScheduleBuilder.calendarIntervalSchedule()
                                .withIntervalInSeconds(2)
                                .withMisfireHandlingInstructionDoNothing()
                ).build();

        scheduler.scheduleJob(jobDetail, trigger);
    }


//    @PostConstruct
    public void delete() throws SchedulerException, InterruptedException {
        Set<JobKey> jobKeys = scheduler.getJobKeys(GroupMatcher.anyGroup());

        jobKeys.forEach(jobKey -> {
//            System.err.println(jobKey.getName());
            try {
                scheduler.deleteJob(jobKey);
            } catch (SchedulerException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
