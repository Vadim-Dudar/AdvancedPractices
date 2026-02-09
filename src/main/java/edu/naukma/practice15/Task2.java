package edu.naukma.practice15;

public class Task2 {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {};
        int[] arr3 = null;

        System.out.println(ArrayStat.calculateAvg(arr1));
        System.out.println(ArrayStat.findMax(arr1));
        System.out.println(ArrayStat.findMin(arr1));

//        System.out.println(ArrayStat.calculateAvg(arr2));
//        System.out.println(ArrayStat.findMax(arr2));
//        System.out.println(ArrayStat.findMin(arr2));

//        System.out.println(ArrayStat.calculateAvg(arr3));
        System.out.println(ArrayStat.findMax(arr3));
//        System.out.println(ArrayStat.findMin(arr3));
    }

}
