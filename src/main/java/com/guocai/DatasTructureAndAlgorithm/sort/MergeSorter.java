package com.guocai.DatasTructureAndAlgorithm.sort;

import java.util.Arrays;

/**
 * java类简单作用描述
 *
 * @ClassName: MergeSorter
 * @Package: com.guocai.DatasTructureAndAlgorithm.sort
 * @Description: 归并排序
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2019-01-06-9:55
 */
public class MergeSorter implements Sorter{
    @Override
    public void sort(int[] arr) {
        sortHelper(arr, 0, arr.length - 1);
    }


    // 帮助方法
    public void sortHelper(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        sortHelper(arr, start, mid);
        sortHelper(arr, mid + 1, end);

        merge(arr, start, mid, mid + 1, end);
    }

    private void merge(int[] arr, int start1, int end1, int start2, int end2) {
        int[] tmp = new int[end1 - start1 + 1 + end2 - start2 + 1];

        int i = start1;
        int j = start2;
        int k = 0;

        while (i <= end1 && j <= end2) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i];
                i++;
            } else {
                tmp[k++] = arr[j];
                j++;
            }
        }

        while (i <= end1 ) {
            tmp[k++] = arr[i];
            i++;
        }

        while (j <= end2 ) {
            tmp[k++] = arr[j];
            j++;
        }

        for (int l = 0; l < k; l++) {
            arr[start1 + l ] = tmp[l];
        }

    }


    public static void main(String[] args){
        int[] arr = SortUtils.buildRandomIntArray(10);
        MergeSorter mergeSorter = new MergeSorter();
        SortUtils.printArray(arr);
        int[] cloneArray = Arrays.copyOf(arr, arr.length);

        Arrays.sort(cloneArray);
        SortUtils.printArray(cloneArray);
        mergeSorter.sort(arr);
        SortUtils.printArray(arr);
    }


}
