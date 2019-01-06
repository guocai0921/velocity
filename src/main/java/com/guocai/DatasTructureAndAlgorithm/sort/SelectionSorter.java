package com.guocai.DatasTructureAndAlgorithm.sort;

import java.util.Arrays;

/**
 * java类简单作用描述
 *
 * @ClassName: SelectionSorter
 * @Package: com.guocai.DatasTructureAndAlgorithm.sort
 * @Description: 选择排序
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2019-01-05-21:11
 */
public class SelectionSorter implements Sorter{
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] <arr[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
        return;
    }

    public static void main(String[] args){
        int[] arr = SortUtils.buildRandomIntArray(10);
        SelectionSorter selectionSorter = new SelectionSorter();
        SortUtils.printArray(arr);
        int[] cloneArray = Arrays.copyOf(arr, arr.length);

        Arrays.sort(cloneArray);
        SortUtils.printArray(cloneArray);
        selectionSorter.sort(arr);
        SortUtils.printArray(arr);
    }

}
