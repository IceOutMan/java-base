package com.meiken.sort;

/**
 * 归并排序
 *
 * 时间复杂度O(nlogn)
 * 不是原地排序
 * 是稳定排序
 *
 * @Author glf
 * @Date 2020/9/2
 */
public class MergeSort {

    public void mergeSort(int[] a,int start,int end){

        if(start>=end) {
            return;
        }

        int middle = (start + end)/2;
        mergeSort(a,start,middle);
        mergeSort(a,middle+1,end);
        merge(a,start,middle,end);

    }

    private void merge(int[] a, int start, int middle, int end) {
        int length = end -start +1;
        int[] temp = new int[length];


        int i =start;
        int j= middle+1;

        length = 0;
        while (i<=middle && j<=end){
            if(a[i] < a[j]){
                temp[length] = a[i];
                i++;
                length++;
            }else {
                temp[length] = a[j];
                j++;
                length++;
            }
        }
        if(i<=middle){
            for(int index = i;index<=middle;index++){
                temp[length] = a[index];
                length++;
            }
        }
        if(j<=end){
            for(int index = j;index<=end;index++){
                temp[length] = a[index];
                length++;
            }
        }

        //合并结果覆盖到原来数组
        for (int index = start;index <=end;index++){
            a[index] = temp[index-start];
        }
    }


    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] a = new int[]{3,8,2};
        mergeSort.mergeSort(a,0,a.length-1);

        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

}
