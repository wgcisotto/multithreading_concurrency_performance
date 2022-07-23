package org.wgcisotto.basics.tasks;

import java.math.BigInteger;

public class LongComputationTask implements Runnable {
    private BigInteger base;
    private BigInteger power;

    public LongComputationTask(BigInteger base, BigInteger power) {
        this.base = base;
        this.power = power;
    }

    @Override
    public void run() {
        System.out.println(base + "^" + power + " = " + pow(base, power));
    }

    private BigInteger pow(BigInteger base, BigInteger power) {
        BigInteger result = BigInteger.ONE;
        for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
            //even that we interrupted the thread this still running until finish the computation
            if (Thread.currentThread().isInterrupted()) { // if thread daemon true no need to add it here.
                System.out.println("Prematurely interrupted computation");
                return BigInteger.ZERO;
            }
            result = result.multiply(base);
        }
        return result;
    }
}