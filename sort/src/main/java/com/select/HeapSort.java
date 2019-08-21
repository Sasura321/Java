package com.select;

import java.util.Arrays;

/**
 * Auther： zsm
 * Date： 2019/8/18 9:04
 * Description：堆排
 */
public class HeapSort {

    public static void heapSort(int[] arr, int len) {
        if (len <= 1)
            return;

        // 1.从第一个非叶子节点开始
        for (int i = len/2-1; i >= 0; i--) {
            // 为了建大堆，向上调整
            adjustHeap(arr, i, len);
        }

        // 2.交换头节点与尾节点，堆变为头节点到位家电的前一个节点，调整堆结构
        for (int i = len-1; i >= 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }

    public static void adjustHeap(int[] arr, int cur, int len) {
        if (cur < len) {
            //左子树和右字数的位置
            int left = 2 * cur + 1;
            int right = 2 * cur + 2;

            //把当前父节点位置看成是最大的
            int max = cur;

            if (left < len) {
                //如果比当前根元素要大，记录它的位置
                if (arr[max] < arr[left]) {
                    max = left;
                }
            }

            if (right < len) {
                //如果比当前根元素要大，记录它的位置
                if (arr[max] < arr[right]) {
                    max = right;
                }
            }

            //如果最大的不是根元素位置，那么就交换
            if (max != cur) {
                int temp = arr[max];
                arr[max] = arr[cur];
                arr[cur] = temp;

            //继续比较，直到完成一次建堆
            adjustHeap(arr, max, len);
            }
        }
    }
    
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,8,9,5,1,3,6,4,7,0};
        heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
