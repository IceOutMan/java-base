package com.meiken.sort;


/**
 * 冒泡排序
 *
 * 时间复杂度：O(n^2)
 * 原地排序
 * 稳定性排序
 *
 * @Author glf
 * @Date 2020/9/1
 */
public class BubbleSort {

    public void sort(int[] a,int n){
        if(n<1 || a.length!=n){
            return;
        }

        for(int times=0;times<n-1;times++){

            boolean swapFlag = false;

            for(int i=1;i<n-times ;i++){
                if(a[i-1] > a[i]){
                    int temp = a[i];
                    a[i]=a[i-1];
                    a[i-1] = temp;

                    swapFlag = true;
                }
            }

            if(!swapFlag){
                return;
            }
        }

    }


    public static void main(String[] args) {

        BubbleSort bubbleSort = new BubbleSort();
        int[] a = new int[]{2,3,6,3,8};
        bubbleSort.sort(a,a.length);

        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
