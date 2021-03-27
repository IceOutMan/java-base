package com.meiken.array;

/**
 * 1.插入、删除、按照下标随机访问
 *
 * 数组中的数据是int类型
 *
 * 插入删除时间复杂度：O(n)
 * 访问时间复杂度:O(1)
 *
 * @Author glf
 * @Date 2020/9/19
 */
public class Array {

    //数据
    public int data[];
    //数组长度
    public int n;
    //数组实际数据个数
    private int count;

    public Array(int capacity){
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    //根据下标访问
    public int find(int index){
        if(index <0 || index>=count){
            return -1;
        }

        return data[index];
    }

    //插入元素
    public boolean insert(int index,int value){

        //数组满
        if(count == n){
            return false;
        }

        //位置不合法
        if(index <0 || index>count){
            return true;
        }

        for(int i= count;i>=index+1;i-- ){
            data[i] = data[i-1];
        }

        data[index] = value;
        count ++ ;

        return true;
    }

    //根据索引删除元素
    public boolean delete(int index){

        //位置不合法
        if(index <0 || index >= count){
            return false;
        }

        for(int i=index + 1;i<count;i++){
            data[i-1] = data[i];
        }

        count--;
        return true;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        Array array = new Array(10);

        //插入
        array.insert(0,0);
        array.insert(1,1);
        array.insert(2,2);
        array.insert(3,3);
        array.insert(4,4);
        array.insert(4,14);
        array.printAll();

        //查找
        System.out.println(array.find(8));

        //删除
        array.delete(4);
        array.printAll();


    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
