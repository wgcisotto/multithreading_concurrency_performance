package org.wgcisotto.metrics.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxMetricsTest {

    @Test
    void addSample() {
        MinMaxMetrics minMaxMetrics = new MinMaxMetrics(5,100);
        assertEquals(5, minMaxMetrics.getMin());
        assertEquals(100, minMaxMetrics.getMax());
        minMaxMetrics.addSample(Long.MIN_VALUE);
        minMaxMetrics.addSample(Long.MAX_VALUE);
        assertEquals(Long.MIN_VALUE, minMaxMetrics.getMin());
        assertEquals(Long.MAX_VALUE, minMaxMetrics.getMax());
    }
}