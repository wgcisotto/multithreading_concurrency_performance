package org.wgcisotto.basics.threads;

import org.wgcisotto.basics.models.Vault;

public class AscendingHackerThread extends HackerThread {
    public static final int MAX_PASSWORD = 9999;

    public AscendingHackerThread(Vault vault) {
        super(vault);
    }

    @Override
    public void run() {
        for (int guess = 0; guess < MAX_PASSWORD; guess++) {
            if (vault.isCorrectPassword(guess)) {
                System.out.println(this.getName() + " guessed the password " + guess);
                System.exit(0);
            }
        }
    }
}