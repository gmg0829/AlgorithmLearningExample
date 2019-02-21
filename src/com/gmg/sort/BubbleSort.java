package com.gmg.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort implements IArraySort {

    @Override
    public  int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 1; i < arr.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) throws Exception{
        BubbleSort bubbleSort=new BubbleSort();
        int[] sourceArray={2,3,1,5,4};
        for (int i = 0; i <  bubbleSort.sort(sourceArray).length; i++) {
            System.out.println( bubbleSort.sort(sourceArray)[i]);
        }
    }
}