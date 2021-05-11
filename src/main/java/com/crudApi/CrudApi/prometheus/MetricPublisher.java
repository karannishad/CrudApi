package com.crudApi.CrudApi.prometheus;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Histogram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class MetricPublisher {

    final ConcurrentHashMap<String, Histogram> metric = new ConcurrentHashMap<>();
    final String HISTOGRAM_METRIC_NAME = "%s_metric";

    @Autowired
    CollectorRegistry collectorRegistry;

    public void createMetric(String metricName) {
        if (!metric.containsKey(metricName))
            metric.put(metricName, Histogram.build().
//                    name(String.format(HISTOGRAM_METRIC_NAME, metricName))
        name("flink_task_manager_allocation_count")
                    .help("Metric for Response Time and Request Count").register(collectorRegistry));
    }


    public Histogram.Timer startTimer(String metricName) {
        return metric.get(metricName).startTimer();
    }


}
