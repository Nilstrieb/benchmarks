import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Primes primes = new DefaultPrimes();
        List<Long> times = new ArrayList<>();
        List<Integer> values = null;

        for (int i = 0; i < 10; i++) {
            System.out.println("iteration " + i + " started");
            long startTime = System.currentTimeMillis();
            values = primes.primes(10_000_000);
            long totalTime = System.currentTimeMillis() - startTime;
            times.add(totalTime);
        }

        double average = times.stream()
                .mapToLong(l -> l)
                .average()
                .getAsDouble();

        System.out.println("Average time after 10 times: " + average + "ms");
    }
}
