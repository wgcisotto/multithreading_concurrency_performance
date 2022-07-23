package org.wgcisotto.basics.threads;

public class CustomThread extends Thread {

    public CustomThread(String name){
        this.setName(name);
    }

    @Override
    public void run() {
        System.out.println("we are now in thread: "+ this.getName());
        System.out.println("Current thread priority is: " + this.getPriority());
    }
}
