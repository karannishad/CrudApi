package com.crudApi.CrudApi.helpers.handler;

import com.crudApi.CrudApi.helpers.LogTime;
import com.crudApi.CrudApi.prometheus.MetricPublisher;
import io.prometheus.client.Histogram;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogTimeHandler {
    Logger logger = LoggerFactory.getLogger(LogTimeHandler.class);

    @Autowired
    MetricPublisher metricPublisher;

    @Around("@annotation(logTime)")
    public Object handleLogTimeEvent(ProceedingJoinPoint joinPoint, LogTime logTime) throws Throwable {
        metricPublisher.createMetric(logTime.name());
        Histogram.Timer timer = metricPublisher.startTimer(logTime.name());
        Object obj = joinPoint.proceed();
        timer.observeDuration();
        return obj;
    }
}
