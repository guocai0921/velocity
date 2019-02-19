package com.guocai.DatasTructureAndAlgorithm.sort;


import java.util.Arrays;

/**
 * java类简单作用描述
 *
 * @ClassName: QuickSorter
 * @Package: com.guocai.DatasTructureAndAlgorithm.sort
 * @Description: 快速排序
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2019-01-06-11:11
 */
public class QuickSorter implements Sorter{

    final static int THRESHOLD = 10;


    public void sortThreeWay(int[] arr, int start, int end) {
        if (end - start <= THRESHOLD - 1) {
            insertionSort(arr, start, end);
            return;
        }

        int pivot = arr[start];
        int lt = start;
        int gt = end;
        int eq = start + 1;

        while (eq <= gt) {
            if (arr[eq] < pivot) {
                swap(arr, lt, eq);
                lt++;
                eq++;
            } else if (arr[eq] > pivot) {
                swap(arr, eq, gt--);
            } else {
                eq++;
            }
        }
        sortThreeWay(arr, start, lt - 1);
        sortThreeWay(arr, gt + 1, end);
    }

    @Override
    public void sort(int[] arr) {
        sortThreeWay(arr, 0, arr.length - 1);
    }

    private void sortHelper(int[] arr, int start, int end) {
        /*if (start >= end) {
            return;
        }*/

        // 当元素小于10个时采用插入排序
        if (end - start <= THRESHOLD - 1) {
            insertionSort(arr, start, end);
            return;
        }

        int median = medianOf3Num(arr, start, (start + (end - start))/2, end);
        swap(arr, start, median);
        int index = partition2(arr, start, end);
        sortHelper(arr, start, index-1);
        sortHelper(arr, index+1, end);

    }

    private void insertionSort(int[] arr, int start, int end) {
        for (int i = start; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i -1 ;
            while (j>=0 && arr[j] > tmp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = tmp;
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start + 1;
        for (int j = start+1; j <= end; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, start, i-1);
        return i-1;
    }

    private int partition2(int[] arr, int start, int end) {
        int pivot = arr[start];

        while (start < end) {
            while (start < end && arr[end] > pivot) {
                end--;
            }
            arr[start] = arr[end];
            while (start < end && arr[start] <= pivot) {
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = pivot;
        return start;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    private int  medianOf3Num(int[] arr, int low, int center, int high) {
        if (arr[low] < arr[center]) {
            if (arr[center] < arr[high]) {
                return center;
            } else {
                return (arr[low] < arr[high]) ? high : low;
            }
        } else {
            if (arr[high] < arr[center]) {
                return center;
            } else {
                return (arr[high] > arr[low]) ? high : low;
            }
        }
    }

    public static void main(String[] args){
        int[] arr = SortUtils.buildRandomIntArray(20);
        QuickSorter quickSorter = new QuickSorter();
        SortUtils.printArray(arr);
        int[] cloneArray = Arrays.copyOf(arr, arr.length);

        Arrays.sort(cloneArray);
        SortUtils.printArray(cloneArray);
        quickSorter.sort(arr);
        SortUtils.printArray(arr);
    }

}
