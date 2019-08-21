package com.exchange;

import java.util.Arrays;

/**
 * Auther： zsm
 * Date： 2019/8/18 8:20
 * Description：冒泡排序
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int flag = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    // 交换
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    // 进到这个这个条件里，证明存在非有序的数
                    flag = 0;
                }
            }

            if (flag == 1)
                return;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,8,9,5,1,3,6,4,7,0};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
