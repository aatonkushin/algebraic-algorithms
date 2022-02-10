package org.tonkushin;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Вычисление чисел Фибоначчи
 */

public class Fibonacci {
    /**
     * Рекурсивный метод
     *
     * @param n число, до которого считаем
     * @return сумма чисел
     */
    public static long calcRecursive(int n) {
        if (n == 0) {
            return 0;
        }

        if (n <= 2) {
            return 1;
        } else {
            return calcRecursive(n - 1) + calcRecursive(n - 2);
        }
    }

    /**
     * Итеративный метод
     *
     * @param n число, до которого считаем
     * @return сумма чисел
     */
    public static BigInteger calcIterative(int n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger c = BigInteger.ZERO;

        for (int i = 2; i <= n; i++) {
            c = a.add(b);
            a = b;
            b = c;
        }

        return c;
    }

    /**
     * Золотое сечение
     * @param n число, до которого считаем
     * @return сумма чисел
     */
    public static BigInteger calcGoldenRatio(int n) {
        BigDecimal fi = BigDecimal.valueOf(5).sqrt(MathContext.DECIMAL128).add(BigDecimal.ONE).divide(BigDecimal.valueOf(2), RoundingMode.DOWN) ;
        System.out.println(fi);
        BigDecimal numerator = fi.pow(n);
        BigDecimal denominator = BigDecimal.valueOf(5).sqrt(MathContext.DECIMAL128);
        return numerator.divide(denominator, RoundingMode.DOWN).add(BigDecimal.valueOf(0.5)).toBigInteger();
    }
}
