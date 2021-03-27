package com.meiken.stack;

/**
 * 栈
 * @Author glf
 * @Date 2020/8/31
 */
public class ArrayStack {

    //栈数组
    private String[] items;
    //栈指针
    private int count;
    //栈大小
    private int n;

    public ArrayStack(int n){
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }


    /**
     * 入栈
     * @param item
     * @return
     */
    public boolean push(String item){
        //栈满判断
        if(count == n) {
            return false;
        }

        items[count] = item;
        count++;
        return true;
    }

    /**
     * 出栈
     * @return
     */
    public String pop(){
        //栈空判断
        if(count == 0){
            return null;
        }
        String item = items[count-1];
        count--;
        return item;
    }
}
