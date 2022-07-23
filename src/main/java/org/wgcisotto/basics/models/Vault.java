package org.wgcisotto.basics.models;

public class Vault {
    private int password;

    public Vault(int password) {
        System.out.println("Password: " + password);
        this.password = password;
    }

    public boolean isCorrectPassword(int guess) {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            //do nothing
        }
        return this.password == guess;
    }
}
