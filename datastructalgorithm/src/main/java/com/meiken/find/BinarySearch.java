package com.meiken.find;


/**
 * 二分查找
 * @Author glf
 * @Date 2020/9/6
 */
public class BinarySearch {

    /**
     * 基础版本
     * 在有序序列中
     * 找到一个符合条件的即返回下标
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int binarySearch(int[] a,int n,int value){

        if(n<1){
            return -1;
        }

        int targetIndex = -1;

        int low = 0;
        int high = n-1;

        while(low <=high){
            int mid = ( high + low)/2;

            if(value < a[mid]){
                high = mid - 1;
            }
            if(a[mid] < value){
                low = mid + 1;
            }
            if(a[mid] == value){
                targetIndex =  mid;
                break;
            }
        }
        return targetIndex;
    }


    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();

//        int[] a = new int[]{1,3,4,5,6,7,8,9};
        int[] a = new int[]{7};

        int targetIndex = binarySearch.binarySearch(a, a.length, 4);
        System.out.println(targetIndex);
    }
}
