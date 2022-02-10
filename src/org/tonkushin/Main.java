package org.tonkushin;

public class Main {

    private static final String powerPath = "D:\\temp\\otus\\3.Power\\";

    public static void main(String[] args) {
        System.out.println("Итеративный алгоритм возведения числа в степень:");
        Power power = new Power();
        power.setMode(Power.MODE.ITERATIVE);
        Tester powerTester = new Tester(power, powerPath);
        powerTester.runTests();

        System.out.println();

        System.out.println("Алгоритм возведения в степень через двоичное разложение показателя степени:");
        power = new Power();
        power.setMode(Power.MODE.POWER_N);
        powerTester = new Tester(power, powerPath);
        powerTester.runTests();



//        System.out.println("Фибоначчи итеративный: " + Fibonacci.calcIterative(1000));
//        System.out.println("Фибоначчи золотое сечение: " + Fibonacci.calcGoldenRatio(1000));

//        int i= 1_000;
//        System.out.println("Простые числа через перебор делителей: " + Prime.divisorsEnumeration(i));
//        System.out.println("Простые числа через деление только на простые: " + Prime.primeDivisorsOnly(i));
//        System.out.println("Простые числа через решето Эратосфена: " + Prime.eratosthenes(i));
    }
}
