package com.meiken.hashtable;


/**
 *
 * 哈希表
 *
 * 访问时间复杂度：O(1)
 * 新增和删除时间复杂度：O(1)
 *
 * @Author glf
 * @Date 2020/9/19
 */
public class HashTable<K,V> {



    //散列表默认长度
    private static final int DEFAULT_INIT_CAPACITY = 8;

    //装填因子
    private static final float LOAD_FACTOR = 0.75f;


    private Entry[] table;

    //实际元素数量
    private int size = 0;

    //散列表索引数量
    private int use = 0;

    public HashTable(){
        table = new Entry[DEFAULT_INIT_CAPACITY];
    }

    //新增
    public void put(K key,V value){

        int index = hash(key);

        if(table[index] == null){
            //创建新的空头节点
            Entry<K,V> newHead = new Entry<>(null,null,null);
            table[index] = newHead;

            Entry<K,V> newData = new Entry<>(key,value,null);
            newHead.next = newData;

            size++;//元素个数+1
            use++;//索引+1

            //新增数据后判断是否扩容
            if(use > table.length * LOAD_FACTOR){
                resize();
            }
        }else{
            //头节点存在
            Entry<K,V> oldHead = table[index];

            //遍历链表，存在相同key节点，更新旧数据
            Boolean nodeExitFlag = false;
            Entry<K,V> p = oldHead.next;
            while (p !=null){
                if(p.key == key){
                    p.value = value;
                    nodeExitFlag = true;
                    break;
                }

                p = p.next;
            }

            //相同key的数据不存在,插入一个新节点
            if(!nodeExitFlag){

                Entry<K,V> newData = new Entry<>(key,value,null);
                newData.next = oldHead.next;
                oldHead.next = newData;

                size ++;//数据个数+1
            }
        }

    }

    private void resize() {
        Entry<K,V>[] oldTable = table;

        table = new Entry[oldTable.length * 2];//扩大2倍
        use = 0;//hash方法用到了索引数组长度，重新判定冲突

        for(int i=0;i<oldTable.length;i++){

            Entry oldHead = oldTable[i];

            //没有数据不用处理
            if(oldHead == null || oldHead.next == null){
                continue;
            }

            //遍历链表
            Entry p = oldHead.next;
            while (p !=null){

                int index = hash(p.key);
                Entry newHead = table[index];
                if(newHead == null){
                    newHead = new Entry(null,null,null);
                    table[index] = newHead;

                    use++;//索引+1
                }
                //扩容的节点不存在相同的KEY了
                Entry newNode = new Entry(p.key,p.value,null);
                newNode.next = newHead.next;
                newHead.next = newNode;

                p = p.next;
            }
        }
    }

    //删除
    public void remove(K key){
        int index = hash(key);
        Entry head = table[index];
        if(head == null || head.next == null){
            return;
        }

        Entry p = head.next;
        Entry preP = head;
        while (p !=null){
            if(p.key == key){
                break;
            }
            preP = p;
            p = p.next;
        }

        //移除
        if(p != null){
            preP.next = p.next;
            size--;
        }
        //use增加是根据索引的头节点创建增加，所以减少也要移除索引头节点
        if(head.next == null){
            table[index] =null;
            use--;
        }
    }

    //查找
    public V get(K key){

        int index = hash(key);
        Entry head = table[index];
        if(head == null || head.next == null){
            return null;
        }

        Entry p = head.next;
        while (p !=null){
            if(p.key == key){
                break;
            }
            p = p.next;
        }

        if(p !=null){
            return (V) p.value;
        }

        return  null;
    }


    public void printAll(){
        for(int i=0;i<table.length;i++){
            Entry head = table[i];
            if(head !=null){
                StringBuilder builder = new StringBuilder();
                Entry p = head.next;

                while (p !=null){
                    builder.append(p.key).append("-");
                    builder.append(p.value).append(", ");

                    p = p.next;
                }

                System.out.println(builder.toString());
            }

        }
    }

    public static void main(String[] args) {
        HashTable<Integer,Integer> hasTable = new HashTable<>();

        hasTable.put(1,1);
        hasTable.put(2,2);
        hasTable.put(3,3);
        hasTable.put(4,4);
        hasTable.printAll();

        hasTable.remove(2);
        hasTable.printAll();

    }


    private int hash(Object key){
        int h ;
//        return (key == null) ? 0 : ((h = key.hashCode()) ^ (h >>> 16)) % table.length;
        return 1;
    }


    public class Entry<K,V>{
        K key;
        V value;

        Entry<K,V> next;

        Entry(K key,V value,Entry<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}

