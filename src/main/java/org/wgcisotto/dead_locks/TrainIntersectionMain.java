package org.wgcisotto.dead_locks;

import org.wgcisotto.dead_locks.models.*;

public class TrainIntersectionMain {

    public static void main(String[] args) {
        //Intersection intersection = new IntersectionDeadLock();
        Intersection intersection = new IntersectionFixed();
        //Intersection intersection = new IntersectionNotBestSolution();
        Thread trainAThread = new Thread(new TrainA(intersection));
        trainAThread.setName("Train A");
        Thread trainBThread = new Thread(new TrainB(intersection));
        trainBThread.setName("Train B");
        trainAThread.start();
        trainBThread.start();
    }

}
