package com.meiken.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 查找时间复杂度：平均-O(logn) 最坏-O(n)
 * 插入时间复杂度：O(logn)
 * 删除时间复杂度：O(logn)
 * @Author glf
 * @Date 2020/9/21
 */
public class BinarySearchTree<K extends Comparable<K>,V> {

    private Node root;//二叉查找树的根节点

    public int size(){
        return this.size(root);
    }

    private int size(Node node){
        if( node == null){
            return 0;
        }
        return node.N;
    }

    //查找某个KEY
    public V get(K key){
        return get(root,key);
    }
    private V get(Node x,K key){
        if(x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);

        if(cmp < 0){
            return get(x.left,key);
        }else if(cmp > 0){
            return get(x.right,key);
        }else{
            return x.value;
        }
    }

    //新增节点，用来构造二叉查找树
    public void put(K key,V value){
        //key 存在-更新，不存在-插入
        root = put(root,key,value);
    }

    private Node put(Node x, K key, V value) {
        if(x == null){
            return new Node(key,value,1);
        }
        int cmp = key.compareTo(x.key);

        //cmp < 0   在左边
        if(cmp < 0){
            x.left =  put(x.left,key,value);
        }
        //cmp > 0   在右边
        else if(cmp > 0){
            x.right = put(x.right,key,value);
        }
        //cmp == 0  相等
        else{
            x.value = value;
        }
        x.N = size(x.left) + size(x.right)  +1;
        return x;
    }

    //max() min() floor() ceiling()
    //select() rank()
    //delete() deleteMin() deleteMax()
    //keys()

    //最小节点 在 最左子树 左子节点上
    public K min(){
        return min(root).key;
    }
    private Node min(Node x){
        if(x.left == null){
            return x;
        }else {
            return min(x.left);
        }
    }

    //最大节点 在 最右子树 右子节点上
    public K max(){
        return max(root).key;
    }
    private Node max(Node x){
        if(x.right == null){
            return x;
        }
        return max(x.right);
    }

    //比key小的最大值
    public K floor(K key){
        Node x = floor(root,key);
        if(x == null){
            return null;
        }
        return x.key;
    }
    private Node floor(Node x,K key){
        if(x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp == 0){
            return x;
        }
        //比key小的都在左子树中
        else if(cmp < 0){
            //左子树中都不存在，说明没有比key小的
            return floor(x.left,key);
        }
        //去右子树中找比 key小的节点
        Node temp = floor(x.right,key);
        //在右子树中没有找到，那么比 key 小的最大值是 x
        if(temp == null){
            return x;
        }else{
            //右子树中找到
            return temp;
        }
    }

    //比 key 大的最小值
    public K ceiling(K key){
        Node x = ceiling(root,key);
        if (x == null){
            return null;
        }
        return  x.key;
    }
    private Node ceiling(Node x, K key){

        if(x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        //相等，就是x身
        if(cmp == 0){
            return x;
        }
        else if(cmp >0){
            //比 key 大的一定在 右子树
            return ceiling(x.right,key);
        }
        //比key大的可能在左子树中还有
        Node temp = ceiling(root.left,key);
        if(temp == null){
            return x;
        }else {
            return temp;
        }

    }

    //查找第K大的数
    public K select(int k){
        return select(root,k).key;
    }

    private Node select(Node x ,int k){
        if(x == null){
            return null;
        }

        int t = size(x.left);
        if(t < k){
            return select(x.right,k-t-1);
        }else if(t > k){
            return select(x.left,k);
        }
        // t==k,x节点就是第K大，也就是比x节点小的有K个
        return x;
    }

    //找到key的排名,也就是比 key小的节点有多少个
    public int rank(K key){
        return rank(root,key);
    }
    private int rank(Node x,K key){
        if(x == null){
            return 0;
        }
        int cmp = key.compareTo(x.key);
        //key < x.key
        if(cmp < 0){
            return rank(x.left,key);
        }
        //x.key < key
        else if(cmp > 0){
            return rank(x.right,key) + size(x.left) + 1;
        }
        //key == x.key
        return size(x.left);
    }

    //删除最小值
    public void deleteMin(){
        root = deleteMin(root);
    }
    private Node deleteMin(Node x){
        if(x.left == null){
            //x是 x为根节点中的最小值，
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;

        return x;
    }

    //删除最大值
    public void deleteMax(){
        root = deleteMax(root);
    }
    private Node deleteMax(Node x){
        if(x.right == null){
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.N = size(x.left)+size(x.right) + 1;
        return x;
    }

    //删除键为key的节点
    public void delete(K key){

    }
    private Node delete(Node x, K key){
        if (x==null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            // key < x.key
            x.left = delete(x.left,key);
        }else if(cmp > 0){
            // key > x.key
            x.right = delete(x.right,key);
        }else {
            //key == x.key
            if(x.left == null){
                return x.right;
            }
            if(x.right == null){
                return x.left;
            }

            //右节点的最小值
            Node rightMin = min(x.right);
            //删除右节点的最小节点
            x.right  = deleteMin(x.right);

            rightMin.left = x.left;
            rightMin.right = x.right;

            x = rightMin;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    //获取节点范围
    public Iterable<K> keys(){
        return keys(min(),max());
    }
    public Iterable<K> keys(K lowKey,K highKey){
        Queue<K> queue = new LinkedList<K>();
        keys(root,queue,lowKey,highKey);
        return queue;
    }
    private void keys(Node x ,Queue queue,K lowKey,K highKey){

        if(x == null){
            return;
        }
        int cmpLow = lowKey.compareTo(x.key);
        int cmpHigh = highKey.compareTo(x.key);

        //lowKey < x.key
        if(cmpLow < 0){
            //x的左子树有在范围内的节点
            keys(x.left,queue,lowKey,highKey);
        }
        // highKey > x.key
        if(cmpHigh > 0){
            //x的右子树有在范围内的节点
            keys(x.right,queue,lowKey,highKey);
        }
        // lowKey <= x.key <= highKey
        if(cmpLow <= 0 && cmpHigh >= 0){
            queue.add(x.key);
        }
    }


    private class Node{
        private K key;
        private V value;

        private Node left,right;
        private int N;//以该节点为根的子树中的节点的个数

        public Node(K key,V value,int N){
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }
}
