package io.github.loulangogogo.config;

import io.gitee.loulan_yxq.owner.core.date.DateTool;
import io.gitee.loulan_yxq.owner.core.date.LocalDateAndTimeFormatTool;
import org.apache.poi.ss.formula.functions.T;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.time.LocalDateTime;

public class TestJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        System.out.println("任务开始运行了---"+context.getJobDetail().getKey().getName()+"---"+ LocalDateAndTimeFormatTool.format(LocalDateTime.now(), "hh:ss"));
    }
}
