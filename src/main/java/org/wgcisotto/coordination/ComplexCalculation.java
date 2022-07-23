package org.wgcisotto.coordination;

import org.wgcisotto.coordination.threads.PowerCalculatingThread;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class ComplexCalculation {

    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) throws InterruptedException {
        PowerCalculatingThread thread1 = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread thread2 = new PowerCalculatingThread(base2, power2);
        List<Thread> threads = Arrays.asList(thread1, thread2);
        for (Thread thread: threads) {
            thread.setDaemon(true);
            thread.start();
        }
        try {
            for (Thread thread: threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return thread1.getResult().add(thread2.getResult());
    }

}