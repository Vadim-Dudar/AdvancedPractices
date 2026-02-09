package edu.naukma.practice15;

public class ArrayStat {

    public static int findMin(int[] array) {
        if (array == null || array.length < 1) throw new IllegalArgumentException("Array is empty!");

        int min = array[0];

        for (int j : array) {
            if (j < min) min = j;
        }

        return min;
    }

    public static int findMax(int[] array) {
        if (array == null || array.length < 1) throw new IllegalArgumentException("Array is empty!");

        int max = array[0];

        for (int j : array) {
            if (j > max) max = j;
        }

        return max;
    }

    public static double calculateAvg(int[] array) {
        if (array == null || array.length < 1) throw new IllegalArgumentException("Array is empty!");

        int sum = 0;
        for (int j : array) {
            sum += j;
        }

        return (double) sum/array.length;
    }

}
