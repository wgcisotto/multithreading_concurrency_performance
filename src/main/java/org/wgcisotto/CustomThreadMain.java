package org.wgcisotto;

import org.wgcisotto.basics.Threads.CustomThread;

public class CustomThreadMain {

    public static void main(String[] args) {
        CustomThread customThread = new CustomThread("Custom Thread");
        customThread.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName());
    }

}
