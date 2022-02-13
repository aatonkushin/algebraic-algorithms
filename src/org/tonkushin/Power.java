package org.tonkushin;

/**
 * Возведение числа в степень
 */

public class Power implements Task {
    public enum MODE {ITERATIVE, POWER_N,}

    private MODE mode;

    public Power(MODE mode) {
        this.mode = mode;
    }

    /**
     * Итеративный O(N) алгоритм возведения числа в степень
     *
     * @param number число
     * @param power  степень
     * @return результат number^power
     */
    public static double calcIterative(double number, long power) {
        double val = 1.0;

        for (long i = 0; i < power; i++) {
            val *= number;
        }

        return val;
    }

    /**
     * алгоритм возведения в степень через двоичное разложение показателя степени O(2LogN) = O(LogN).
     *
     * @param number число
     * @param power  степень
     * @return результат number^power
     */
    public static double powerN(double number, long power) {
        if (power == 0) {
            return 1.0;
        }
        double res = 1.0;
        double sq = number;
        while (power > 1) {
            if (power % 2 == 1) {
                res *= sq;
            }
            sq = sq * sq;
            power /= 2;
        }

        res *= sq;
        return res;
    }

    @Override
    public String run(String[] data) {
        double number = Double.parseDouble(data[0]);
        long power = Long.parseLong(data[1]);

        switch (mode) {
            case ITERATIVE:
                return String.valueOf(calcIterative(number, power));
            case POWER_N:
                return String.valueOf(powerN(number, power));
        }

        throw new RuntimeException("Алгоритм не распознан");
    }
}
