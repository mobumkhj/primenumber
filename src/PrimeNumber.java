import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimeNumber {
    DB db;
    Structure structure;

    public PrimeNumber() {
        db = new DB();
        structure = new Structure();
    }

    private long findPrimeNumber(long n) {
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

    public List<Long> makePrimeNumbers(long number, int order) {
        List primeNumbers = new ArrayList<Integer>();

        for (long i = 2; i <= number; i++) {
            long prime = findPrimeNumber(i);
            if (prime != 0) {
                primeNumbers.add(prime);
            }
        }

        if (order == 1) {
            Collections.reverse(primeNumbers);
        }

        return primeNumbers;

    }

    // 1 : backward
    public List<Long> getPrimeNumbers(long number, int order) {
        List<Long> output = null;
        String data = db.getPrimeNumbers(number);

        if (data == null) {
            output = makePrimeNumbers(number, order);
            savePrimeNumbers(output);
        } else {
            output = structure.getPrimeList(data, order);
        }

        return output;
    }

    private void savePrimeNumbers(List<Long> primeNumbers) {
        String data = structure.getPrimeString(primeNumbers);
        db.savePrimeNumber(data);
    }
}
