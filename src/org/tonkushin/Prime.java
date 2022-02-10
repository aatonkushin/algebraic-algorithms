package org.tonkushin;

import java.util.Arrays;

/**
 * Поиск простых чисел
 */

public class Prime {
    /**
     * Поиск количества простых чисел через перебор делителей (O(N^2))
     *
     * @param n число, до которого ищем
     * @return количество простых чисел
     */
    public static long divisorsEnumeration(int n) {
        int retVal = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                retVal++;
            }
        }

        return retVal;
    }

    /**
     * алгоритм поиска простых чисел с оптимизациями поиска и делением только на простые числа, O(N * Sqrt(N) / Ln (N))
     *
     * @param n число, до которого ищем
     * @return количество простых чисел
     */
    public static long primeDivisorsOnly(int n) {
        int count = 0;
        long[] primes = new long[n / 2];

        primes[count++] = 2;

        for (int i = 3; i <= n; i++) {
            if (isPrime(i, primes)) {
                primes[count++] = i;
            }
        }

        return count;
    }

    /**
     * Решето Эратосфена
     * @param n число, до которого ищем
     * @return количество простых чисел
     */
    public static long eratosthenes(int n) {
        double sqrt = Math.sqrt(n);

        boolean[] divs = new boolean[n + 1];
        long count = 0;

        for (int p = 2; p <= n; p++) {
            if (!divs[p]) {
                count++;
                if (p < sqrt) {
                    for (int j = p * p; j <= n; j += p) {
                        divs[j] = true;
                    }
                }
            }
        }

        return count;
    }

    private static boolean isPrime(int p) {
        if (p == 2) {
            return true;
        }
        if (p % 2 == 0) {
            return false;
        }

        int sqrt = (int) Math.sqrt(p);
        for (int i = 3; i <= sqrt; i += 2) {
            if (p % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isPrime(int p, long[] primes){
        int sqrt = (int) Math.sqrt(p);
        for (int i = 0; primes[i] <= sqrt; i++) {
            if (p % primes[i] == 0) {
                return false;
            }
        }

        return true;
    }
}
