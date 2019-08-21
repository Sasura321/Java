package com.exchange;

import java.util.Arrays;

/**
 * Auther： zsm
 * Date： 2019/8/18 8:33
 * Description：快排
 */
public class QuickSort {

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right)
            return;

        // 找一个基准值
        int index = sort(arr, left, right);
        // index已经排好序

        quickSort(arr, left, index-1);
        quickSort(arr, index+1, right);
    }

    public static int sort(int[] arr, int left, int right) {
        // 找一个基准值
        int key = arr[right];

        while (left < right) {
            while(left < right && arr[left] <= key)
                left++;
            arr[right] = arr[left];

            while (left < right && arr[right] >= key)
                right--;
            arr[left] = arr[right];
        }
        arr[right] = key;
        return right;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,8,9,5,1,3,6,4,7,0};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
