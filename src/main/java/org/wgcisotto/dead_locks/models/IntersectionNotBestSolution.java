package org.wgcisotto.dead_locks.models;

public class IntersectionNotBestSolution implements Intersection {
    private Object roadA = new Object();
    private Object roadB = new Object();

    /**
     * To avoid deack lock condition here basically the waiting condition in both thread are the same order
     * lock road A -> lock road B in both scenarios
     */

    public synchronized void takeRoadA() {
        //synchronized (roadA) {
            System.out.println("Road A is locked by thread " + Thread.currentThread().getName());

            //synchronized (roadB) {
                System.out.println("Train is passing through road A");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
          //  }
        //}
    }

    public synchronized void takeRoadB() {
        //synchronized (roadA) {
            System.out.println("Road B is locked by thread " + Thread.currentThread().getName());

            //synchronized (roadB) {
                System.out.println("Train is passing through road B");

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
            //}
        //}
    }
}
