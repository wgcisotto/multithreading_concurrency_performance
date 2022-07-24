package org.wgcisotto.metrics.threads;

import org.wgcisotto.metrics.models.Metrics;

public class MetricsPrinter extends Thread {
    private Metrics metrics;

    public MetricsPrinter(Metrics metrics) {
        this.metrics = metrics;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }

            double currentAverage = metrics.getAverage();

            System.out.println("Current Average is " + currentAverage);
        }
    }
}