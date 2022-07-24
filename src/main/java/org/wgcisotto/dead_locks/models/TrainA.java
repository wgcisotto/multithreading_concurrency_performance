package org.wgcisotto.dead_locks.models;

import java.util.Random;

public class TrainA implements Runnable {
    private Intersection intersectionDeadLock;
    private Random random = new Random();

    public TrainA(Intersection intersectionDeadLock) {
        this.intersectionDeadLock = intersectionDeadLock;
    }

    @Override
    public void run() {
        while (true) {
            long sleepingTime = random.nextInt(5);
            try {
                Thread.sleep(sleepingTime);
            } catch (InterruptedException e) {
            }

            intersectionDeadLock.takeRoadA();
        }
    }
}