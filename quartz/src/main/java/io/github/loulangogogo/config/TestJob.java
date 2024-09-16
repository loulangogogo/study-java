package io.github.loulangogogo.config;

import io.github.loulangogogo.water.date.LocalDateAndTimeFormatTool;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;

public class TestJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        System.out.println("任务开始运行了---"+context.getJobDetail().getKey().getName()+"---"+ LocalDateAndTimeFormatTool.format(LocalDateTime.now(), "hh:ss"));
    }
}
