package org.wgcisotto.metrics.threads;

import org.wgcisotto.metrics.models.Metrics;

import java.util.Random;

public class BusinessLogic extends Thread {
    private Metrics metrics;
    private Random random = new Random();

    public BusinessLogic(Metrics metrics) {
        this.metrics = metrics;
    }

    @Override
    public void run() {
        while (true) {
            long start = System.currentTimeMillis();

            try {
                Thread.sleep(random.nextInt(2));
            } catch (InterruptedException e) {
            }

            long end = System.currentTimeMillis();

            metrics.addSample(end - start);
        }
    }
}