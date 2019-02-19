package com.guocai.DatasTructureAndAlgorithm.search;

/**
 * java类简单作用描述
 *
 * @ClassName: BinarySearch
 * @Package: com.guocai.DatasTructureAndAlgorithm.search
 * @Description: 二分查找
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2019-01-27-9:10
 */
public class BinarySearch {

    public static int bsearch(int[] arr, int start, int end, int targetValue) {
        if (start > end) {
            return -1;
        }

        int mid = start + ((end - start) >> 1);

        if (arr[mid] == targetValue) {
            return mid;
        } else if (arr[mid] < targetValue) {
            return bsearch(arr, mid + 1, end, targetValue);
        } else {
            return bsearch(arr, start, mid - 1, targetValue);
        }

    }

    public static int bsearchInterator(int[] arr, int start, int end, int targetValue) {
        if (start > end) {
            return -1;
        }

        while (start <= end) {
            int mid = start + ((end - start) >> 1);

            if (arr[mid] == targetValue) {
                return mid;
            } else if (arr[mid] < targetValue) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 5, 5, 5, 5, 7, 9, 10, 10, 10, 10, 10, 15, 18, 20};

        // int bsearch = bsearch(arr, 0, arr.length -1, 15);
        // System.out.println("bsearch = " + bsearch);
        // int bsearchInterator = bsearchInterator(arr, 0, arr.length -1, 20);
        // System.out.println("bsearchInterator = " + bsearchInterator);
        // int bsearchSameNumFirst = bsearchSameNumFirst(arr, 0, arr.length - 1, 10);
        // System.out.println("bsearchSameNumFirst = " + bsearchSameNumFirst);
        int bsearchSameNumLast = bsearchSameNumLast(arr, 0, arr.length - 1, 10);
        System.out.println("bsearchSameNumLast = " + bsearchSameNumLast);

    }

    /*
     * @description: 查找有序数组中元素第一次出现的位置，数组里有相同的元素
     * @auther: Sun GuoCai
     * @datetime: 2019/1/27 10:09
     * @param: arr
     * @param: start
     * @param: end
     * @param: targetValue
     * @return: int
     */
    public static int bsearchSameNumFirst(int[] arr, int start, int end, int targetValue) {
        if (start > end) {
            return -1;
        }


        int res = -1;

        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (arr[mid] >= targetValue) {
                end = mid - 1;
                if (arr[mid] == targetValue) {
                    res = mid;
                }
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    /*
     * @description: 查找有序数组中元素第后出现的位置，数组里有相同的元素
     * @auther: Sun GuoCai
     * @datetime: 2019/1/27 10:09
     * @param: arr
     * @param: start
     * @param: end
     * @param: targetValue
     * @return: int
     */
    public static int bsearchSameNumLast(int[] arr, int start, int end, int targetValue) {
        if (start > end) {
            return -1;
        }


        int res = -1;

        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (arr[mid] <= targetValue) {
                start = mid + 1;
                if (arr[mid] == targetValue) {
                    res = mid;
                }
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

}


















