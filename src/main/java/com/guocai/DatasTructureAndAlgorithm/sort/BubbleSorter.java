package com.guocai.DatasTructureAndAlgorithm.sort;

import java.util.Arrays;

/**
 * java类简单作用描述
 *
 * @ClassName: BubbleSort
 * @Package: com.guocai.DatasTructureAndAlgorithm.sort
 * @Description: 冒泡排序
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2019-01-05-19:46
 */
public class BubbleSorter implements Sorter{
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1){
            return;
        } else {
            for (int i = 0; i < arr.length; i++) {
                boolean flag = false;
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] > arr[j+1]) {
                        int tmp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = tmp;
                        flag = true;
                    }
                }
                if (!flag){
                    break;
                }
            }
        }

    }

    public static void main(String[] args){
        int[] arr = SortUtils.buildRandomIntArray(10);
        BubbleSorter bubbleSorter = new BubbleSorter();
        SortUtils.printArray(arr);
        int[] cloneArray = Arrays.copyOf(arr, arr.length);

        Arrays.sort(cloneArray);
        SortUtils.printArray(cloneArray);
        bubbleSorter.sort(arr);
        SortUtils.printArray(arr);
    }

}
