package com.meiken.tree;

import java.util.NoSuchElementException;

/**
 * 一种比较平衡二叉查找树，从 2-，3- 树引申出来
 * @Author glf
 * @Date 2020/9/22
 */
public class RedBlackBST<K extends Comparable<K>,V> {

    private Node root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;


    public int size(){
        return this.size(root);
    }

    private int size(Node node){
        if( node == null){
            return 0;
        }
        return node.N;
    }

    public boolean isEmpty(){
        return root == null;
    }


    private boolean isRed(Node h){
        if(h == null) {
            return false;
        }
        return h.color == RED;
    }

    //左旋
    private Node rotateLeft(Node h){
        Node hRight = h.right;

        //结构变换
        h.right = hRight.left;
        hRight.left = h;

        //颜色变换
        hRight.color = h.color;
        h.color = RED;

        //节点数变换
        hRight.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;

        return hRight;
    }

    //右旋
    private Node rotateRight(Node h){
        Node hLeft = h.left;

        //结构变化
        h.left = hLeft.right;
        hLeft.right = h;

        //颜色变化
        hLeft.color = h.color;
        h.color = RED;

        //节点数变换
        hLeft.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;

        return hLeft;
    }

    //颜色变换
    private void flipColors(Node h){
        h.left.color = !h.left.color;
        h.right.color =!h.right.color;

        h.color = !h.color;
    }


    //新增
    public void put(K key,V value){
        root = put(root,key,value);

        //根节点的颜色保持黑色
        root.color = BLACK;
    }
    private Node put(Node h,K key,V value){
        //自低向上进行平衡
        if(h ==null){
            //新增的节点都是红色
            return new Node(key,value,1,RED);
        }
        int cmp = key.compareTo(h.key);
        //key < h.key
        if(cmp < 0){
            h.left = put(h.left,key,value);
        }
        //key > h.key
        else if(cmp > 0){
            h.right = put(h.right,key,value);
        }else{
            //更新旧值
            h.value = value;
        }

        //以 H 为根节点，存在三种情况
        //1.left left.left 都为为红色
        if(isRed(h.left) && isRed(h.left.left)){
            h = rotateRight(h);//右旋  -> 右旋之后可能需要变换颜色
        }
        //2.只有 right 为红色
        if(isRed(h.right) && !isRed(h.left)){
            h = rotateLeft(h);//左旋
        }
        //3.left right 为红色
        if(isRed(h.left) && isRed(h.right)){
            flipColors(h);//颜色反转
        }
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    //TODO:删除一个节点
    public void delete(K key){
        if(key == null){
            throw new IllegalArgumentException("argument to delete() is null");
        }

        if(!contains(key)){
            return;
        }

        //如果根节点的两个孩子都是黑色,根节点颜色变为红色
        if(!isRed(root.left) && !isRed(root.right)){
            root.color = RED;
        }

        root = delete(root,key);

        if(!isEmpty()){
            root.color = BLACK;
        }
    }

    private Node delete(Node h,K key){
        if(key.compareTo(h.key) < 0){
            if(!isRed(h.left) && !isRed(h.left.left)){
                h = moveRedLeft(h);
            }
            h.left = delete(h.left,key);
        }else{
            if(isRed(h.left)){
                h = rotateRight(h);
            }
            if(key.compareTo(h.key) == 0 && (h.right == null)){
                return null;
            }
            if(!isRed(h.right) && !isRed(h.right.left)){
                h = moveRedRight(h);
            }
            if(key.compareTo(h.key) == 0){
                Node x = min(h.right);
                h.key = x.key;
                h.value = x.value;

                h.right = deleteMax(h.right);
            }else {
                h.right = delete(h.right,key);
            }
        }

        return null;
    }

    public void deleteMin(){
        if(isEmpty()) {
            throw new NoSuchElementException("BST underflow");
        }
        //如果根节点的两个孩子节点都是黑色节点，根节点颜色变为红色,保证当前节点是3-节点
        if(!isRed(root.left) && !isRed(root.right)){
            root.color = RED;
        }

        root = deleteMin(root);

        if(!isEmpty()){
            root.color =BLACK;
        }
    }

    private Node deleteMin(Node h){
        if(h.left == null){
            return null;
        }

        //说明 h.left映射到 2-3树中是 2-的节点
       if(!isRed(h.left) && !isRed(h.left.left)){
           h = moveRedLeft(h);//把右边的红色节点变换到左边
       }
       h.left = deleteMin(h.left);
       return balance(h);
    }



    private Node moveRedLeft(Node h){
        flipColors(h);
        if(isRed(h.right.left)){
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }


    public void deleteMax(){
        if(isEmpty()){
            throw new NoSuchElementException("BTS underflow");
        }

        //如果根节点的两个孩子节点都是黑色节点，根节点颜色变为红色,保证当前节点是3-节点
        if(!isRed(root.left) && !isRed(root.right)){
            root.color = RED;
        }
        root = deleteMax(root);
        if(!isEmpty()){
            root.color = BLACK;
        }
    }

    private Node deleteMax(Node h){
        if(isRed(h.left)){
            h = rotateRight(h);
        }

        if(h.right == null){
            return null;
        }
        if(!isRed(h.right) && !isRed(h.right.left)){
            h = moveRedRight(h);
        }

        h.right = deleteMax(h.right);
        return balance(h);

    }

    private Node moveRedRight(Node h){
        flipColors(h);
        if(isRed(h.left.left)){
            h = rotateRight(h);
            flipColors(h);
        }
        return h;
    }



    private Node balance(Node h){
        //1.left left.left 都为为红色
        if(isRed(h.left) && isRed(h.left.left)){
            h = rotateRight(h);//右旋  -> 右旋之后可能需要变换颜色
        }
        //2.只有 right 为红色
        if(isRed(h.right) && !isRed(h.left)){
            h = rotateLeft(h);//左旋
        }
        //3.left right 为红色
        if(isRed(h.left) && isRed(h.right)){
            flipColors(h);//颜色反转
        }
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    //树的高度
    public int height(){
        return height(root);
    }
    private int height(Node x){

        if(x == null) {
            return -1;
        }
        return 1 + Math.max(height(x.left),height(x.right));
    }

    //最小值
    public K min(){
        if(isEmpty()) {
            throw new NoSuchElementException("calls min() with empty symbol table");
        }

        return min(root).key;
    }
    private Node min(Node x){
        if(x.left == null){
            return x;
        }else{
            return min(x.left);
        }
    }

    //最大值
    public K max(){
        if(isEmpty()) {
            throw new NoSuchElementException("calls min() with empty symbol table");
        }

        return max(root).key;
    }
    private Node max(Node x){
        if(x.right == null){
            return  x;
        }else{
            return max(x.right);
        }
    }

    //获取
    public V get(K key){
        //和普通二叉查找树的操作一样，包括最大值最小值等等，只是构建和删除的逻辑不同
        if(key == null){
            throw new IllegalArgumentException("argument to get() is null");
        }
        return get(root,key);
    }

    private V get(Node x,K key){
        while (x != null){
            int cmp = key.compareTo(x.key);
            if(cmp < 0){
                x = x.left;
            }else if(cmp > 0){
                x = x.right;
            }else{
                return x.value;
            }
        }
        return  null;
    }

    public boolean contains(K key){
        return get(key) != null;
    }

    private class Node{
        K key;
        V value;

        Node left,right;
        int N;
        boolean color;//由其父节点指向它的连接的颜色

        Node(K key,V value,int N,boolean color){
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }
    }


}
