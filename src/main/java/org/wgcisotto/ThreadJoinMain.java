package org.wgcisotto;

import org.wgcisotto.coordination.threads.FactorialThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadJoinMain {
    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers = Arrays.asList(100000000L, 3435L, 35435L, 2324L, 4656L, 23L, 5556L);
        List<FactorialThread> threads = new ArrayList<>();
        for (long inputNumber : inputNumbers) {
            threads.add(new FactorialThread(inputNumber));
        }
        for (Thread thread : threads) {
            thread.setDaemon(true);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join(2000);
        }
        for (int i = 0; i < inputNumbers.size(); i++) {
            FactorialThread factorialThread = threads.get(i);
            if (factorialThread.isFinished()) {
                System.out.println("Factorial of " + inputNumbers.get(i) + " is " + factorialThread.getResult());
            } else {
                System.out.println("The calculation for " + inputNumbers.get(i) + " is still in progress");
            }
        }
    }
}
