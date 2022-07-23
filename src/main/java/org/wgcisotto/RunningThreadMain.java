package org.wgcisotto;

public class RunningThreadMain {

    public static void main(String[] args) throws InterruptedException {
        //A thread receives an Runnable run() Method
        //As Runnable is an interface with only one method abstract
        //That makes it an Functional Interface, and we can collapse to a lambda
        Thread thread = new Thread(() -> {
        //Code that will run in  a new thread
            System.out.println("we are now in thread: "+Thread.currentThread().getName());
            System.out.println("Current thread priority is: " + Thread.currentThread().getPriority());
        });
        thread.setName("New Worker Thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " before starting a new thread");
        thread.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " after starting a new thread");
        Thread.sleep(10000);
    }

}
