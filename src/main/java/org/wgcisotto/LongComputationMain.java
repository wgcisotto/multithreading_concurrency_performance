package org.wgcisotto;

import org.wgcisotto.basics.tasks.LongComputationTask;

import java.math.BigInteger;

public class LongComputationMain {

    public static void main(String[] args) {
        LongComputationTask longComputationTask1 = new LongComputationTask(new BigInteger("2"), new BigInteger("10"));
        Thread thread = new Thread(longComputationTask1);
        thread.start();
        LongComputationTask longComputationTask = new LongComputationTask(new BigInteger("200000"), new BigInteger("100000000"));
        thread = new Thread(longComputationTask);
        thread.setDaemon(true);//like that the thread in interrupted gracefully and we dont need to handle on the Task.
        thread.start();
        thread.interrupt();
    }

}
