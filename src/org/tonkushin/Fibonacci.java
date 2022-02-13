package org.tonkushin;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Вычисление чисел Фибоначчи
 */

public class Fibonacci implements Task {

    public enum MODE {RECURSIVE, ITERATIVE, GOLDEN}

    private final MODE mode;

    public Fibonacci(Fibonacci.MODE mode) {
        this.mode = mode;
    }

    /**
     * Рекурсивный метод
     *
     * @param n число, до которого считаем
     * @return сумма чисел
     */
    public static long calcRecursive(int n) {
        if (n <= 1) {
            return n;
        }

        return calcRecursive(n - 1) + calcRecursive(n - 2);
    }

    /**
     * Итеративный метод
     *
     * @param n число, до которого считаем
     * @return сумма чисел
     */
    public static BigInteger calcIterative(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }

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
     *
     * @param n число, до которого считаем
     * @return сумма чисел
     */
    public static BigInteger calcGoldenRatio(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }

        BigDecimal fi = BigDecimal.valueOf(5).sqrt(MathContext.DECIMAL128).add(BigDecimal.ONE).divide(BigDecimal.valueOf(2), RoundingMode.DOWN);
        BigDecimal numerator = fi.pow(n);
        BigDecimal denominator = BigDecimal.valueOf(5).sqrt(MathContext.DECIMAL128);

        return numerator.divide(denominator, RoundingMode.DOWN).add(BigDecimal.valueOf(0.5)).toBigInteger();
    }

    private static long recursiveN;

    @Override
    public String run(String[] data) {
        int number = Integer.parseInt(data[0]);
        switch (mode) {
            case RECURSIVE: {
                if (number < 50) {
                    return String.valueOf(calcRecursive(number));
                }

                return "-1";
            }
            case ITERATIVE:
                return String.valueOf(calcIterative(number));
            case GOLDEN:
                return String.valueOf(calcGoldenRatio(number));
        }

        throw new RuntimeException("Алгоритм не распознан");
    }
}
