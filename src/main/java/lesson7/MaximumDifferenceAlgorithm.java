package lesson7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
* This class provides two different algorithms for solving the maximum difference problem.
* The algorithm should find the largest difference between any two numbers in the given list.
* For example in list of [4, 24, 1, 9, 5], the maximum differe is between numbers 24 and 1, which is 23.
*/
public class MaximumDifferenceAlgorithm {
    public static Integer getMaximumDifferenceA(List<Integer> numbers) {
        // TODO
        return -1;
    }

    public static Integer getMaximumDifferenceB(List<Integer> numbers) {
        // TODO
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(getMaximumDifferenceA(List.of(4, 24, 1, 9, 5))); // should be 23

        List<Integer> testList = generateTestList(10_000_000);

        long startA = System.currentTimeMillis();
        Integer resultA = getMaximumDifferenceA(testList);
        long durationA = System.currentTimeMillis() - startA;
        System.out.println("A result: " + resultA + ", time: " + durationA + " ms");

        long startB = System.currentTimeMillis();
        Integer resultB = getMaximumDifferenceB(testList);
        long durationB = System.currentTimeMillis() - startB;
        System.out.println("B result: " + resultB + ", time: " + durationB + " ms");
    }

    /*
     * This method generates a list of random integers between 0 and 100 of the
     * given size.
     */
    private static List<Integer> generateTestList(int size) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(101));
        }
        return list;
    }
}
