package com.insert;

import java.util.Arrays;

/**
 * Auther： zsm
 * Date： 2019/8/18 11:34
 * Description：直接插入排序
 */
public class InsertSort {

    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            int temp = arr[i];

            while (index > 0 && arr[index-1] > temp) {
                arr[index] = arr[index-1];
                index--;
            }

            arr[index] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,8,9,5,1,3,6,4,7,0};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
