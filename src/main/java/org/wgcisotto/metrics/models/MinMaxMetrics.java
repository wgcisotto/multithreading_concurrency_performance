package org.wgcisotto.metrics.models;

public class MinMaxMetrics {
    private volatile long min;
    private volatile long max;

    /**
     * Initializes all member variables
     */
    public MinMaxMetrics(long min, long max) {
        this.min = min;
        this.max = max;
    }

    /**
     * Adds a new sample to our metrics.
     */
    public synchronized void addSample(long newSample) {
        synchronized (this){
            this.min = Math.min(newSample, min);
            this.max = Math.max(newSample, max);
        }
    }

    /**
     * Returns the smallest sample we've seen so far.
     */
    public long getMin() {
        return min;
    }

    /**
     * Returns the biggest sample we've seen so far.
     */
    public long getMax() {
        return max;
    }
}
