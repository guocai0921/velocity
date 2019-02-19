package com.guocai.DatasTructureAndAlgorithm.sort;

import java.util.Arrays;

/**
 * java类简单作用描述
 *
 * @ClassName: CountSorter
 * @Package: com.guocai.DatasTructureAndAlgorithm.sort
 * @Description: 计数排序
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2019-01-06-19:24
 */
public class CountSorter implements Sorter{
    @Override
    public void sort(int[] arr) {
        int max = findMax(arr);
        int[] count = new int[max+1];
        count(arr, count);
        rebuild(arr, count);
    }

    public int[] sort2(int[] arr) {
        int max = findMax(arr);
        int[] count = new int[max+1];
        count(arr, count);
        totalCount(count);
        return rebuildV2(arr, count);
    }

    private int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    private void count(int[] arr, int[] c) {
        for (int i : arr) {
            c[i]++;
        }
    }


    private void totalCount(int[] count) {
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum += count[i];
            count[i] = sum;
        }
    }

    private int[] rebuildV2(int[] arr, int[] totalCount) {
        int[] sortedArr = new int[arr.length];
        for (int i = arr.length - 1; i >=0 ; i--) {
            sortedArr[totalCount[arr[i]] - 1] = arr[i];
            totalCount[arr[i]]--;
        }
        return sortedArr;
    }


    private void rebuild(int[] arr, int[] count) {
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[index++] = i;
            }
        }
    }

    public static void main(String[] args){
        int[] arr = SortUtils.buildRandomIntArray(10);
        CountSorter countSorter = new CountSorter();
        SortUtils.printArray(arr);
        int[] cloneArray = Arrays.copyOf(arr, arr.length);

        Arrays.sort(cloneArray);
        SortUtils.printArray(cloneArray);
        int[] arrs = countSorter.sort2(arr);
        SortUtils.printArray(arrs);
    }

}
