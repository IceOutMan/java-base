package com.meiken.hashtable;

import java.util.HashMap;

/**
 * @Author glf
 * @Date 2020/9/20
 */
public class LRUCacheBaseHashTable<K,V> {

    private HashMap<K,CacheNode> table;

    private CacheNode head;
    private CacheNode tail;

    private int length;

    public LRUCacheBaseHashTable(int capacity){
        table = new HashMap<K, CacheNode>(capacity);

        CacheNode initHead = new CacheNode(null,null,null);
        CacheNode initTail = new CacheNode(null,null,null);

        initHead.next = initTail;
        initTail.pre = initHead;

        this.head = initHead;
        this.tail = initTail;

        length = 0;

    }

    //增
    public void put(K key,V value){

        CacheNode oldCacheNode = table.get(key);
        if(oldCacheNode == null){
            //节点不存在，插入头部
            CacheNode newNode = new CacheNode(value,null,null);
            table.put(key,newNode);

            newNode.next = head.next;
            newNode.pre = head;

            head.next = newNode;

            length++;

        }else{
            //存在，更新数据并移动到链表头部
            oldCacheNode.value = value;
            table.put(key,oldCacheNode);

            oldCacheNode.pre.next = oldCacheNode.next;
            oldCacheNode.next.pre = oldCacheNode.pre;

            oldCacheNode.next = head.next;
            oldCacheNode.pre = head;

            head.next = oldCacheNode;
        }


    }

    //删
    public void remove(K key){
        CacheNode targetNode = table.get(key);

        if (targetNode != null){
            //从数组中
            table.remove(key);

            //从链表中删除
            targetNode.pre.next = targetNode.next;
            targetNode.next.pre = targetNode.pre;

            length--;
        }
    }


    //查找
    public V get(K key){
        CacheNode oldCacheNode = table.get(key);
        if(oldCacheNode == null){
            return null;
        }

        oldCacheNode.next = head.next;
        oldCacheNode.pre = head;

        head.next = oldCacheNode;
        return oldCacheNode.value;
    }


    class CacheNode{

        public V value;

        public CacheNode pre;
        public CacheNode next;

        public CacheNode(V value,CacheNode pre,CacheNode next){
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRUCacheBaseHashTable<Integer,Integer> lruTable = new LRUCacheBaseHashTable<>(10);

        lruTable.put(1,1);
        lruTable.put(2,2);
        lruTable.put(3,3);

    }


}
