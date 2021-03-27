package com.meiken.sort;

/**
 * 计数排序
 *
 * 时间复杂度：O(n)
 * 不是原地排序
 * 是稳定排序
 * @Author glf
 * @Date 2020/9/3
 */
public class CountSort {
    public void countSort(int[] a){
        if(a.length <=1){
            return;
        }

        int min = a[0];
        int max = a[0];
        for(int i=0;i<a.length;i++){
            if(a[i]<min){
                min = a[i];
            }
            if(a[i]>max){
                max = a[i];
            }
        }


        for(int i=0;i<a.length;i++){
            a[i] = a[i] - min;
        }

        int[] C = new int[max-min+1];

        for(int i=0;i<a.length;i++){
            C[a[i]]++;
        }

        for(int i=1;i<C.length;i++){
            C[i] = C[i] + C[i-1];
        }

        int[] temp =new int[a.length];
        for(int i=a.length-1;i>=0;i--){
           int index = C[a[i]];
           temp[index-1] = a[i];
           C[a[i]]--;
        }

        for(int i=0;i<a.length;i++){
            a[i] = temp[i];
            a[i]=a[i]+min;
        }
    }


    public static void main(String[] args) {
        CountSort countSort = new CountSort();

        int[] a = new int[]{5,2};
        countSort.countSort(a);

        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
