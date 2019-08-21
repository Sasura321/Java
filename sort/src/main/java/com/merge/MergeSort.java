package com.merge;

import java.util.Arrays;

/**
 * Auther： zsm
 * Date： 2019/8/18 15:05
 * Description：
 */
public class MergeSort {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right)
            return;

        int mid = (left+right)/2;
        mergeSort(arr, left, mid);
        mergeSort(arr,mid+1, right);
        sort(arr, left,mid+1,right);
    }

    public static void sort(int[] arr, int left, int mid, int right) {
        int[] leftArr = new int[mid-left];
        int[] rightArr = new int[right-mid+1];

        // 数据填充
        for (int i = left; i < mid; i++) {
            leftArr[i-left] = arr[i];
        }
        for (int i = mid; i <= right; i++) {
            rightArr[i-mid] = arr[i];
        }

        int a = 0;
        int b = 0;
        int k = left;

        while (a < leftArr.length && b < rightArr.length) {
            if (leftArr[a] <= rightArr[b]) {
                arr[k] = leftArr[a];
                k++;
                a++;
            } else {
                arr[k] = rightArr[b];
                k++;
                b++;
            }
        }

        while (a < leftArr.length) {
            arr[k] = leftArr[a];
            k++;
            a++;
        }

        while (b < rightArr.length) {
            arr[k] = rightArr[b];
            k++;
            b++;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,8,9,5,1,3,6,4,7,0};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
