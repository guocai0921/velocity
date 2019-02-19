import java.util.Arrays;

/**
 * java类简单作用描述
 *
 * @ClassName: QuickSorter
 * @Package: velocity
 * @Description: 快速排序
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2019-01-07-20:04
 */
public class QuickSorter {
    
    public static void main(String[] args){
        int[] arr = new int[]{4,9,78,1,0,2,100,8,3,23,7,5,6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));

    }
    
    public static void quickSort(int[] arr, int start, int end){
        if (start < end){
            int i = start;
            int j = end;
            int temp = arr[i];
            while (i < j) {
                while (i<j && arr[j] > temp) {
                    j--;
                }
                arr[i] = arr[j];
                while (i<j && arr[i] < temp) {
                    i++;
                }
                arr[j] = arr[i];
            }
            arr[i] = temp;
            quickSort(arr, start, i - 1);
            quickSort(arr, i + 1, end);
        }

    }

    
}
