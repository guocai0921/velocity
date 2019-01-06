package com.guocai.DatasTructureAndAlgorithm.sort;

import java.util.Arrays;

/**
 * java类简单作用描述
 *
 * @ClassName: InsertSorter
 * @Package: com.guocai.DatasTructureAndAlgorithm.sort
 * @Description: 插入排序
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2019-01-05-20:52
 */
public class InsertSorter implements Sorter{
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1){
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int element = arr[i];
            int j = i - 1;
            while (j>=0 && element < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = element;
        }
    }

    public static void main(String[] args){
        int[] arr = SortUtils.buildRandomIntArray(10);
        InsertSorter insertSorter = new InsertSorter();
        SortUtils.printArray(arr);
        int[] cloneArray = Arrays.copyOf(arr, arr.length);

        Arrays.sort(cloneArray);
        SortUtils.printArray(cloneArray);
        insertSorter.sort(arr);
        SortUtils.printArray(arr);
    }

}
