package com.gmg.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return quickSort(arr, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    public static void main(String[] args) {
        int array[]={32, 12, 7, 78, 23, 45};
        quickSort1(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
    public static void quickSort1(int array[],int left,int right)
    {
        if(left>=right)
        {
            return ;
        }
        int i=left;
        int j=right;
        int key=array[left];
        while(i<j)
        {
            while(i<j&&array[j]>key)
            {
                j--;
            }
            array[i]=array[j];
            //从后往前找到第一个比key小的数与array[i]交换；
            while(i<j&&array[i]<key)
            {
                i++;
            }
            array[j]=array[i];
            //从前往后找到第一个比key大的数与array[j]交换；
        }
        array[i]=key;
        //一趟快排之后已经将key的位置找到。
        quickSort1(array,left,i-1);
        //对key左边的进行排序
        quickSort1(array,i+1,right);
        //对key右边的进行排序
    }

}
