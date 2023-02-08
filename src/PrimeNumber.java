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
        List primeNumbers = makePrimeNumbers1(number);

        if (order == 1) {
            Collections.reverse(primeNumbers);
        }

        return primeNumbers;

    }

    public List<Long> makePrimeNumbers1(long number) {
        List primeNumbers = new ArrayList<Long>();
        boolean prime[] = new boolean[(int) number + 1];

        prime[0] = prime[1] = true;

        for (int i = 2; i * i <= number; i++) {
            // prime[i]가 소수라면
            if (!prime[i]) {
                // prime[j] 소수가 아닌 표시
                for (int j = i * i; j <= number; j += i) prime[j] = true;
            }
        }

        // 소수 출력
        for (int i = 1; i <= number; i++) {
            if (!prime[i]) primeNumbers.add((long)i);
        }


        return primeNumbers;

    }

    public List<Long> makePrimeNumbers2(long number) {
        List primeNumbers = new ArrayList<Long>();

        for (long i = 2; i <= number; i++) {
            long prime = findPrimeNumber(i);
            if (prime != 0) {
                primeNumbers.add(prime);
            }
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
