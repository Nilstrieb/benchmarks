import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Sort {
    public static void main(String[] args) {

        for (int i = 1; i < 6; i++) {
            List<Long> times = new ArrayList<>();
            int size = (int) Math.pow(10, i);
            for (int j = 0; j < 10; j++) {
                int[] arr = getRandomArray(size);
                long startTime = System.currentTimeMillis();
                bubbleSort(arr);
                long totalTime = System.currentTimeMillis() - startTime;
                times.add(totalTime);
            }

            double average = times.stream()
                    .mapToLong(l -> l)
                    .average()
                    .getAsDouble();

            System.out.printf("Average time after 10 times for array size %d : %.2fms%n", size, average);

        }
    }

    public static int[] getRandomArray(int size) {
        int[] arr = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt();
        }
        return arr;
    }

    public static int[] bubbleSort(int[] arr) {
        for (boolean isSorted = false; !isSorted;){
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }

        }
        return arr;
    }

    /**
     * Sorts an already sorted array
     * @param arr The sorted array
     * @return A sorted array
     */
    public static int[] quickSortAlreadySorted(int[] arr) {
        return arr;
    }
}

