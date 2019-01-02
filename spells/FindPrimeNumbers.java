package spells;

import java.util.stream.Stream;

/**
 * @author Rafael Bernabeu
 */
public class FindPrimeNumbers {

    public static void main(String... args) {
        Stream.iterate(0, n -> n + 1)
                .filter(FindPrimeNumbers::ehPrimo)
                .limit(1000)
                .forEach(System.out::println);

    }

    public static Boolean ehPrimo(Integer n) {
        for (int i = 1; i <= n; i++) { if (i == 1 || i == n) { continue; }
            if (n % i == 0) { return false; }
        } return true;
    }
}
