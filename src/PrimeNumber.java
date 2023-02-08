import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {
    public static long findPrimeNumber(long n) {
        if (n == 1) {
            return 0;
        }
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return 0;
            }
        }
        return n;
    }

    List<Integer> makePrimeNumber(long number) {
        List primeNumbers = new ArrayList<Integer>();

        for (long i = 2; i <= number; i++) {
            long prime = findPrimeNumber(i);
            if (prime != 0) {
                primeNumbers.add(prime);
            }
        }

        return primeNumbers;

    }
}
