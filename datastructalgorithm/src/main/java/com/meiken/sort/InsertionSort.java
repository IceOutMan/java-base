package com.meiken.sort;

/**
 * 插入排序
 * 时间复杂度：O(n^2)
 * 原地排序
 * 稳定排序
 * @Author glf
 * @Date 2020/9/1
 */
public class InsertionSort {

    public void sort(int[] a,int n){
        if(n<1 || a.length != n){
            return;
        }

        for(int index=1;index<n;index++){

            int insertIndex = index;
            int insertValue = a[index];

            for(int i=index-1;i>=0;i--){
                if(a[index]<a[i]){
                    a[i+1] = a[i];
                    insertIndex = i;
                }
            }
            a[insertIndex] = insertValue;
        }

    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] a = new int[]{2,3,6};
        insertionSort.sort(a,a.length);

        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

}
