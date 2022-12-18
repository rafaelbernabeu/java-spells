package spells;

import java.util.stream.IntStream;

/**
 * @author Rafael Bernabeu
 */
public class FindPrimeNumbers {

    public static void main(String... args) {
        IntStream.range(0, 1_000_000)
                .filter(FindPrimeNumbers::ehPrimo)
                .forEach(System.out::println);

    }

    public static Boolean ehPrimo(Integer n) {
        for (int i = 1; i <= n; i++) { if (i == 1 || i == n) { continue; }
            if (n % i == 0) { return false; }
        } return true;
    }
}
