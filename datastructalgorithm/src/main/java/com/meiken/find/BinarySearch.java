package com.meiken.find;
import java.util.Arrays;

/**
 * 二分查找
 * @Author glf
 * @Date 2020/9/6
 */
public class BinarySearch {

    /**
     * 找到一个符合条件的即返回下标
     * @param  key  目标值
     * @param a 有序数组
     * @return
     */
    public int binarySearch(int key, int[] a){
        int lo = 0;
        int hi = a.length - 1;
        while ( lo <= hi){
            int mid = (hi + lo)/2;
            if(a[mid] < key){
                lo = mid + 1;
            }else if(key < a[mid]){
                hi = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();

        int[] a = new int[]{10,1,3,4,5,6,7,8,9};
        Arrays.sort(a);
        int targetIndex = binarySearch.binarySearch(4, a);
        System.out.println("index:"+targetIndex+" value:" + a[targetIndex]+"");
    }
}
