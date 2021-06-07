import java.util.ArrayList;
import java.util.List;

public class DefaultPrimes implements Primes {

    // (will make the code 15% slower)
    @SuppressWarnings("ForLoopReplaceableByForEach")
    public List<Integer> primes(int max) {
        List<Integer> primesList = new ArrayList<>(max);

        primesList.add(2);

        for (int i = 3; i < max; i++) { //go through all numbers
            boolean isPrime = true;
            double sqrRoot = Math.sqrt(i);
            for (int j = 0; j < primesList.size(); j++) { //test each number
                int prime = primesList.get(j);
                if (prime >= sqrRoot) {
                    break;
                }
                if (i % prime == 0) { //i = test number, j = some known prime
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primesList.add(i);
            }
        }

        return primesList;
    }
}
