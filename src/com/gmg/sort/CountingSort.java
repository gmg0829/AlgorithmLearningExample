package com.gmg.sort;

import java.util.Arrays;

/**
 * 计数排序
 */
public class CountingSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int maxval = getMaxval(arr);

        return countingSort(arr, maxval);
    }

    private int[] countingSort(int[] arr, int maxval) {
        int bucketLen = maxval + 1;
        int[] bucket = new int[bucketLen];

        for (int val : arr) {
            bucket[val]++;
        }

        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }

    private int getMaxval(int[] arr) {
        int maxval = arr[0];
        for (int val : arr) {
            if (maxval < val) {
                maxval = val;
            }
        }
        return maxval;
    }

}
