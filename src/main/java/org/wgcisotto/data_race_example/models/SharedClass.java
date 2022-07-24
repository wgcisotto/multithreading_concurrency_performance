package org.wgcisotto.data_race_example.models;

public class SharedClass {
    private int x = 0; // volatile resolve the issue in the race condition
    private int y = 0;

    public synchronized void increment() {
        x++;
        y++;
    }

    public synchronized void checkForDataRace() {
        if (y > x) {
            System.out.println("y > x - Data Race is detected");
        }
    }
}