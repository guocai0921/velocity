package com.guocai.DatasTructureAndAlgorithm.search;

import com.guocai.DatasTructureAndAlgorithm.sort.BubbleSorter;
import com.guocai.DatasTructureAndAlgorithm.sort.SortUtils;

/**
 * java类简单作用描述
 *
 * @ClassName: QuickSelect
 * @Package: com.guocai.DatasTructureAndAlgorithm.search
 * @Description: 快速查找最大数
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2019-01-13-16:31
 */
public class QuickSelect {

    public int quickSelect(int[] arr, int k) {
        return quickSelectHelper(arr, k, 0, arr.length - 1);
    }

    // 在start和end之间选择一个随机数
    private int selectPivot(int start, int end){
        return start + (int) Math.floor(Math.random() * (end - start + 1));
    }

    // 方法二
    public  int quickSelectHelperIterator(int[] arr, int k, int start, int end) {
        if (start == end) {
            return arr[start];
        }

        while (true) {
            int pivotIndex = selectPivot(start, end);
            pivotIndex = partition(arr, start, end, pivotIndex);
            if (pivotIndex == k) {
                return arr[k];
            } else if (k < pivotIndex) {
                end = pivotIndex - 1;
            } else {
                start = pivotIndex + 1;
            }

        }


    }


    // 方法一
    public  int quickSelectHelper(int[] arr, int k, int start, int end) {
        if (start == end) {
            return arr[start];
        }

        int pivotIndex = selectPivot(start, end);

        pivotIndex = partition(arr, start, end, pivotIndex);

        if (pivotIndex == k) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelectHelper(arr, k, start, pivotIndex - 1);
        } else {
            return quickSelectHelper(arr, k, pivotIndex + 1, end);
        }

    }


    // O(n)
    private int partition(int[] arr, int start, int end, int pivotIndex) {
        int pivot = arr[pivotIndex];
        swap(arr, start, pivotIndex);
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

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args){
        int[] arr = SortUtils.buildRandomIntArray(10);
        SortUtils.printArray(arr);
        // BubbleSorter bubbleSorter = new BubbleSorter();
        // bubbleSorter.sort(arr);
        QuickSelect select = new QuickSelect();
        int i = select.quickSelect(arr, 6);
        System.out.println(i);
        SortUtils.printArray(arr);
        int j = select.quickSelect(arr, 8);
        System.out.println(j);
        SortUtils.printArray(arr);

    }

}
