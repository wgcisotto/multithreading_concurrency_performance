package org.wgcisotto.metrics;

import org.wgcisotto.metrics.models.Metrics;
import org.wgcisotto.metrics.threads.BusinessLogic;
import org.wgcisotto.metrics.threads.MetricsPrinter;

public class MetricsSystemMain {

    public static void main(String[] args) {
        Metrics metrics = new Metrics();
        BusinessLogic businessLogicThread1 = new BusinessLogic(metrics);
        BusinessLogic businessLogicThread2 = new BusinessLogic(metrics);
        MetricsPrinter metricsPrinter = new MetricsPrinter(metrics);
        businessLogicThread1.start();
        businessLogicThread2.start();
        metricsPrinter.start();
    }

}
