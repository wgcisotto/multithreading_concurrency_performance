package org.wgcisotto;

import org.wgcisotto.basics.Threads.AscendingHackerThread;
import org.wgcisotto.basics.Threads.DescendingHackerThread;
import org.wgcisotto.basics.Threads.PoliceThread;
import org.wgcisotto.basics.models.Vault;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BreakingVaultMain {

    public static final int MAX_PASSWORD = 9999;

    public static void main(String[] args) {
        Random random = new Random();
        Vault vault = new Vault(random.nextInt(MAX_PASSWORD));
        List<Thread> threads = new ArrayList<>();
        threads.add(new AscendingHackerThread(vault));
        threads.add(new DescendingHackerThread(vault));
        threads.add(new PoliceThread());
        //Iteration via polymorphism
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
