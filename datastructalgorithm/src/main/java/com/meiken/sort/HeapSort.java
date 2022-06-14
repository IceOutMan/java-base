package com.meiken.sort;

/**
 * 堆排序
 * 时间复杂度：O(nlogn)
 *
 * 1.满二叉树
 * 2.子结点都小于等于或者大于等于父节点
 *
 *
 * 堆化 + 排序
 * 使用数组实现最大顶堆栈
 */
public class HeapSort {

    private int[] a;    //数组，从下标1开始存储数据
    private int n;  //堆可以存储的最大数据个数
    private int count;  //堆中已存储的数据个数

    public HeapSort(int capacity){
        a = new int[capacity+1];
        n = capacity;
        count = 0;
    }

    // 入堆
    public void insert(int data){
        if(count >=n) {
            return;   //堆满了
        }

        ++count;
        a[count] = data;
        int i = count;
        while(i/2>0 && a[i] > a[i/2]){  //自下往上堆化
            swap(a, i , i/2);   // swap 函数：交换下标为 i 和 i/2 的两个元素
            i = i/2;
        }
    }

    // 移除最大值
    public void removeMax(){
        if(count == 0){
            return; //堆中没有数据
        }
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    /**
     * 构建堆 - 从第一个非叶子结点的位置开始 index = n/2
     * @param a
     * @param n
     */
    public static void buildHeap(int[] a , int n){
        for(int i = n/2; i>=1; --i){
            heapify(a, n, i);
        }
    }

    public static void sort(int[] a, int n){
        buildHeap(a, n);
        int k = n;
        while(k > 1){
            swap(a, 1, k);
            --k;
            heapify(a,k,1);
        }
    }

    /**
     * 堆化i结点 - 从上到下堆化
     * @param a
     * @param n
     * @param i
     */
    public  static void heapify(int[] a, int n, int i){    //自上往下堆化
       while(true){
           int maxPos  = i;
           // i 的左子结点
           if(i*2 <= n && a[i] < a[i*2]) {
               maxPos = i*2;
           }
           // i 的右子结点
           if(i*2+1 <= n && a[maxPos] < a[i*2+1]){
               maxPos = i*2+1;
           }
           if(maxPos == i){
               break;
           }
           // 找到最大值交换
           swap(a,i,maxPos);
           i = maxPos;
       }
    }

    public static void swap(int[] a ,int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }


}
