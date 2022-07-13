import java.sql.Time;

/**
 * Assignment 4 for CS 1410
 * This program evaluates the linear and binary searching, along
 * with comparing performance difference between the selection sort
 * and the built-in java.util.Arrays.sort.
 *
 * @author James Dean Mathias
 */
public class EvaluationDriver {
    static final int MAX_VALUE = 1_000_000;
    static final int MAX_ARRAY_SIZE = 100_000;
    static final int ARRAY_SIZE_START = 20_000;
    static final int ARRAY_SIZE_INCREMENT = 20_000;
    static final int NUMBER_SEARCHES = 50_000;

    public static void main(String[] args) {

       demoLinearSearchUnsorted();
       demoLinearSearchSorted();
       demoBinarySearchSelectionSort();
       demoBinarySearchFastSort();
    }

    public static int[] generateNumbers(int howMany, int maxValue) {
        if (howMany > 0) {
            int[] numbers = new int[howMany];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = (int)(Math.random() * maxValue);

            }
            return numbers;
        }
        return null;
    }

    public static boolean linearSearch(int[] data, int search) {
        for (int number : data) {
            if (number == search) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] data, int search) {
        int start = 0;
        int end = data.length - 1;
        int middle = (start + end)/2;
        while(start <= end) {
            if (data[middle] == search) {
                return true;
            }
            else if (data[middle] < search) {
                start = middle + 1;
            }else {
                end = middle - 1;
            }
            middle = (start + end)/2;
        }
        return false;
    }

    public static void selectionSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int position = findSmallestValuePosition(data, i);
            swap(i, position, data);
        }
    }

    private static int findSmallestValuePosition(int[] data, int start) {
        int position = start;
        for (int i = start; i < data.length; i ++) {
            if (data[i] < data[position]) {
                position = i;
            }
        }
        return position;
    }

    private static void swap(int position1, int position2, int[] data) {
        int temp = data[position1];
        data[position1] = data[position2];
        data[position2] = temp;
    }

    public static void demoLinearSearchUnsorted() {
        System.out.println("--- Linear Search Timing (unsorted) ---");
        int currentSize = ARRAY_SIZE_START;
        while (currentSize <= MAX_ARRAY_SIZE) {
            int[] data = generateNumbers(currentSize, MAX_VALUE);
            long startTime = System.currentTimeMillis();
            int foundValue = linearSearchLoop(data);
            long endTime = System.currentTimeMillis();
            printResults(currentSize, foundValue, endTime - startTime);
            currentSize += ARRAY_SIZE_INCREMENT;
        }
    }

    public static void demoLinearSearchSorted() {
        System.out.println("--- Linear Search Timing (Selection Sort) ---");
        int currentSize = ARRAY_SIZE_START;
        while (currentSize <= MAX_ARRAY_SIZE) {
            int[] data = generateNumbers(currentSize, MAX_VALUE);
            long startTime = System.currentTimeMillis();
            selectionSort(data);
            int foundValue = linearSearchLoop(data);
            long endTime = System.currentTimeMillis();
            printResults(currentSize, foundValue, endTime - startTime);
            currentSize += ARRAY_SIZE_INCREMENT;
        }
    }

    private static void printResults(int sizeOfArray, int timesFound, long searchTime) {
        System.out.printf("%-22s: %1d\n", "Number of items", sizeOfArray);
        System.out.printf("%-22s: %1d\n", "Times value was found", timesFound);
        System.out.printf("%-22s: %d ms\n\n", "Total search time", searchTime);
    }

    public static void demoBinarySearchSelectionSort() {
        System.out.println("--- Binary Search Timing (Selection Sort) ---");
        int currentSize = ARRAY_SIZE_START;
        while (currentSize <= MAX_ARRAY_SIZE) {
            int[] data = generateNumbers(currentSize, MAX_VALUE);
            long startTime = System.currentTimeMillis();
            selectionSort(data);
            int foundValue = binarySearchLoop(data);
            long endTime = System.currentTimeMillis();
            printResults(currentSize, foundValue, endTime - startTime);
            currentSize += ARRAY_SIZE_INCREMENT;
        }
    }

    public static void demoBinarySearchFastSort() {
        System.out.println("--- Binary Search Timing (Arrays.sort) ---");
        int currentSize = ARRAY_SIZE_START;
        while (currentSize <= MAX_ARRAY_SIZE) {
            int[] data = generateNumbers(currentSize, MAX_VALUE);
            long startTime = System.currentTimeMillis();
            java.util.Arrays.sort(data);
            int foundValue = binarySearchLoop(data);
            long endTime = System.currentTimeMillis();
            printResults(currentSize, foundValue, endTime - startTime);
            currentSize += ARRAY_SIZE_INCREMENT;
        }
    }

    private static int binarySearchLoop(int[] data) {
        int foundValue = 0;
        for (int i = 0; i < NUMBER_SEARCHES; i++) {
            double value = Math.random() * MAX_VALUE;
            if (binarySearch(data, (int)value)) {
                foundValue++;
            }
        }
        return foundValue;
    }

    private static int linearSearchLoop(int[] data) {
        int foundValue = 0;
        for (int i = 0; i < NUMBER_SEARCHES; i++) {
            double value = Math.random() * MAX_VALUE;
            if (linearSearch(data, (int)value)) {
                foundValue++;
            }
        }
        return foundValue;
    }
}
