package com.insert;

import java.util.Arrays;

/**
 * Auther： zsm
 * Date： 2019/8/18 14:35
 * Description：
 */
public class ShellSort {
    public static void shellSort(int[] arr, int len) {
        // 开始分组，最开始的数组增量（gap）为数组长度的一般
        for (int gap = len/2; gap > 0; gap /= 2) {
            // 对各个分组进行插入排序
            for (int i = gap; i < len; i++) {
                sort(arr, gap, i);
            }
        }
    }

    public static void sort(int[] arr, int gap, int i) {
        int temp = arr[i];
        int k = i - gap;
        while (k >= 0 && temp < arr[k]) {
            arr[k+gap] = arr[k];
            k -= gap;
        }

        arr[k+gap] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,8,9,5,1,3,6,4,7,0};
        shellSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
