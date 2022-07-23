package org.wgcisotto.coordination;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class ComplexCalculationTest {

    @Test
    void calculateResult() throws InterruptedException {
        ComplexCalculation complexCalculation = new ComplexCalculation();
        BigInteger result = complexCalculation.calculateResult(BigInteger.TEN, BigInteger.TWO, BigInteger.TEN, BigInteger.TWO);
        Assertions.assertEquals(BigInteger.valueOf(200), result);
    }
}