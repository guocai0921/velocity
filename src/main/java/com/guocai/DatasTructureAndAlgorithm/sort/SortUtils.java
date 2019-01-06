package com.guocai.DatasTructureAndAlgorithm.sort;

import java.util.Arrays;
import java.util.Random;

 
public class SortUtils {
 	public static  void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
    
	public static int[] buildRandomIntArray() {
		return buildRandomIntArray(100000);
	}

	public static int[] buildRandomIntArray(final int size) {
		int[] arrayToCalculateSumOf = new int[size];
		Random generator = new Random();
		for (int i = 0; i < arrayToCalculateSumOf.length; i++) {
			arrayToCalculateSumOf[i] = generator.nextInt(1000); //Integer.MAX_VALUE);
		}
		return arrayToCalculateSumOf;
	}
	
	
	public static boolean isEquals(int[] arr1, int[] arr2) {
		if(arr1 == null && arr2 == null)
			return true;
		if(arr1 == null || arr2 == null)
			return false;
		
		int len1 = arr1.length;
		if(len1 != arr2.length)
			return false;
		
		for(int i=0; i<len1; i++) {
			if(arr1[i] != arr2[i])
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
        int[] arrayToSort = SortUtils.buildRandomIntArray(20);
        SortUtils.printArray(arrayToSort);
        int[] expectedArray = Arrays.copyOf(arrayToSort, arrayToSort.length);
        expectedArray[expectedArray.length-1] = 1;

        if(!SortUtils.isEquals(arrayToSort,  (expectedArray)))
        	System.out.println("The two array is not equal ... ");
        else
        	System.out.println("The two array is equal ... ");

	}
	
}
