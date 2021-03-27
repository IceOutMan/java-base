package com.meiken.sort;

import com.sun.org.apache.bcel.internal.generic.Select;

/**
 * 选择排序
 *
 * 时间复杂度：O(n^2)
 * 原地排序
 * 不稳定排序
 * @Author glf
 * @Date 2020/9/1
 */
public class SelectionSort {

    public void sort(int[] a,int n){
        if(n<1 || a.length != n){
            return;
        }

        for(int times=0;times<n-1;times++){

            int minValue = a[times];
            int minIndex = times;
            for(int i=times;i<n;i++){
                if(a[i]<minValue){
                    minValue = a[i];
                    minIndex = i;
                }
            }
            a[minIndex] = a[times];
            a[times] = minValue;
        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] a = new int[]{54,5};
        selectionSort.sort(a,a.length);

        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
