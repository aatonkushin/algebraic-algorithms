package org.tonkushin;

public class Main {

    private static final String powerPath = "D:\\temp\\otus\\3.Power\\";
    private static final String fiboPath = "D:\\temp\\otus\\4.Fibo\\";
    private static final String primesPath = "D:\\temp\\otus\\5.Primes\\";

    public static void main(String[] args) {
        power();

        fibonacci();

        primes();
    }

    private static void power() {
        System.out.println("Итеративный алгоритм возведения числа в степень:");
        Task power = new Power(Power.MODE.ITERATIVE);
        Tester powerTester = new Tester(power, powerPath);
        powerTester.runTests();

        System.out.println();

        System.out.println("Алгоритм возведения в степень через двоичное разложение показателя степени:");
        power = new Power(Power.MODE.POWER_N);
        powerTester = new Tester(power, powerPath);
        powerTester.runTests();

        System.out.println("=== === === ===");
    }

    private static void fibonacci() {
        System.out.println("Фибоначчи рекурсивный:");
        Task task = new Fibonacci(Fibonacci.MODE.RECURSIVE);
        Tester tester = new Tester(task, fiboPath);
        tester.runTests();

        System.out.println("Фибоначчи итеративный:");
        task = new Fibonacci(Fibonacci.MODE.ITERATIVE);
        tester = new Tester(task, fiboPath);
        tester.runTests();

        System.out.println("Фибоначчи по формуле золотого сечения:");
        task = new Fibonacci(Fibonacci.MODE.GOLDEN);
        tester = new Tester(task, fiboPath);
        tester.runTests();

        System.out.println("=== === === ===");
    }

    private static void primes() {
        System.out.println("Простые числа через перебор делителей:");
        Task task = new Prime(Prime.MODE.DIVISORS);
        Tester tester = new Tester(task, primesPath);
        tester.runTests();

        System.out.println("Простые числа через деление только на простые:");
        task = new Prime(Prime.MODE.PRIME_DIVISORS);
        tester = new Tester(task, primesPath);
        tester.runTests();

        System.out.println("Простые числа через решето Эратосфена:");
        task = new Prime(Prime.MODE.ERATOSTHENES);
        tester = new Tester(task, primesPath);
        tester.runTests();

        System.out.println("=== === === ===");
    }
}
