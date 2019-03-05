package com.gmg.array;

/**
 * @author gmg
 * @Title:
 * @Package
 * @Description: 合并两个有序数组为有序数组
 * 简单的思路就是先放到一个新的数组中，再排序。但是这样的没体现任何算法，这里考的不是快速排序等排序算法。
 * 关键应该是如何利用有序已知这个条件。可以这样想，假设两个源数组的长度不一样，那么假设其中短的数组用完了，
 * 即全部放入到新数组中去了，那么长数组中剩下的那一段就可以直接拿来放入到新数组中去了。
 * @date 2019/3/5  9:03
 */
public class SortTwoSortedArray {
    public static int[] merge(int[] a, int[] b) {
        int lena = a.length;
        int lenb = b.length;
        int[] c = new int[lena + lenb];
        int i = 0, j = 0, k = 0;//分别代表数组a ,b , c 的索引
        while (i < lena && j < lenb) {
            if (a[i] < b[j])
                c[k++] = a[i++];
            else
                c[k++] = b[j++];
        }
        while (i < lena)
            c[k++] = a[i++];
        while (j < lenb)
            c[k++] = b[j++];
        return c;
    }

    public static void main(String[] args) {
        int[] c = merge(new int[] { 1, 2, 3, 4 }, new int[] { 0, 2, 4, 5,
                6, 7, 8 });
        for (int i = 0; i < c.length; i++)
            System.out.println(c[i]);
    }

}
