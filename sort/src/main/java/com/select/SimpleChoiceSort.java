package com.select;

import java.util.Arrays;

/**
 * Auther： zsm
 * Date： 2019/8/18 10:51
 * Description：简单选择排序
 */
public class SimpleChoiceSort {

    public static void choiceSort(int[] arr) {
        if (arr == null && arr.length <= 1)
            return;

        for (int i = 0; i < arr.length; i++) {
            int min = i;

            for (int j = i+1; j < arr.length; j++) {
                if (arr[min] > arr[j])
                    min = j;
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,8,9,5,1,3,6,4,7,0};
        choiceSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
