package com.meiken.sort;

/**
 * 快速排序
 *
 *  时间复杂度：O(nlogn)
 *  不是稳定排序
 *  原地排序
 *
 *  思路：[start....end]数组的end作为分割点的值，设置哨兵为数组的start
 *      哨兵左边都是存储小于分割点的元素，哨兵右边存储的是大于等于分割点的元素
 *      遍历：由于哨兵初始值是start，相当于是遍历数组，把数组中小于分割点的元素放到哨兵的左边，最后交换
 * @Author glf
 * @Date 2020/9/3
 */
public class QuickSort {


    public void quickSort(int[] a,int start,int end){

        if(start >=end){
            return;
        }

        int pivot = partition(a,start,end);

        quickSort(a,start, pivot-1);
        quickSort(a,pivot+1,end);

    }

    private int partition(int[] a, int start, int end) {
        int i=start;
        int pivotValue=a[end];

        for(int j = start;j<end;j++){
            if(a[j]<pivotValue){
                int temp = a[j];
                a[j]=a[i];
                a[i]=temp;
                i++;
            }
        }

        a[end] = a[i];
        a[i] = pivotValue;
        return i;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] a = new int[]{34,82,23,444,3555,66666};
        quickSort.quickSort(a,0,a.length-1);

        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
