package com.gmg.sort;

import java.util.Arrays;

/**
 * 桶排序
 */
public class BucketSort implements IArraySort {

    private static final InsertSort insertSort = new InsertSort();

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return bucketSort(arr, 5);
    }

    private int[] bucketSort(int[] arr, int bucketSize) throws Exception {
        if (arr.length == 0) {
            return arr;
        }

        int minval = arr[0];
        int maxval = arr[0];
        for (int val : arr) {
            if (val < minval) {
                minval = val;
            } else if (val > maxval) {
                maxval = val;
            }
        }

        int bucketCount = (int) Math.floor((maxval - minval) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];

        // 利用映射函数将数据分配到各个桶中
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i] - minval) / bucketSize);
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }

        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            // 对每个桶进行排序，这里使用了插入排序
            bucket = insertSort.sort(bucket);
            for (int val : bucket) {
                arr[arrIndex++] = val;
            }
        }

        return arr;
    }

    /**
     * 自动扩容，并保存数据
     *
     * @param arr
     * @param val
     */
    private int[] arrAppend(int[] arr, int val) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = val;
        return arr;
    }

}
