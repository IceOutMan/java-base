package com.meiken.tree;

/**
 *
 * 第0层是普通的链表
 * @Author glf
 * @Date 2020/9/30
 */
public class SkipList {

    private static final float SKIPLIST_P = 0.5f;
    private static final int MAX_LEVEL = 16;

    private int levelCount = 1;

    private Node head = new Node();


    //增
    public void insert(int value){
        int level = randomLevel();

        Node newNode = new Node();
        newNode.data =value;
        newNode.maxLevel = level;

        Node[] update = new Node[level];
        for (int i=0;i<level;i++){
            update[i] = head;
        }

        //记录每一层 比 value小的最大值
        Node p = head;
        for(int i=level - 1;i>=0;i--){
            while (p.forwards[i] != null && p.forwards[i].data < value){
                p = p.forwards[i];
            }
            update[i] = p;
        }

        //  update[i] < newNode< update[i].forwards[i]
        for(int i=0;i<level;i++){
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }

        //update node high
        if(levelCount < level) {
            levelCount = level;
        }
    }

    //删
    public void delete(int value){
        Node[] update = new Node[levelCount];
        Node p = head;
        //找到每一层比 value小的最大值
        for(int i=levelCount-1;levelCount >= 0;i--){
            while (p.forwards[i] != null && p.forwards[i].data < value){
                p = p.forwards[i];
            }
            update[i] = p;
        }


        if(p.forwards[0] != null && p.forwards[0].data == value){
            //value 存在
            for(int i = levelCount -1;i>=0;i--){
                // update[i] -> nodeValue
                if(update[i].forwards[i] != null && update[i].forwards[i].data == value){
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }

        //update high
        while(levelCount > 1 && head.forwards[levelCount] == null){
            levelCount--;
        }
    }

    //查
    public Node find(int value){
        Node p = head;

        //最高层 -> 0 层
        for(int i= levelCount - 1; i>= 0;--i){
            while (p.forwards[i] != null && p.forwards[i].data < value){
                p = p.forwards[i];
            }
        }
        //循环比较找到节点 p.forwards
        if(p.forwards[0] != null && p.forwards[0].data == value){
            return p.forwards[0];
        }else{
            return null;
        }
    }

    //理论来讲，一级索引中元素个数应该占原始数据的50%，二级索引中元素个数占25%，三级索引12.5% ，一直到最顶层。
    //因为这里每一层的晋升概率是50%。对于每一个新插入的节点，都需要调用randomLevel生成一个合理的层数。
    //该randomLevel方法会随机生成1~MAX_LEVEL之间的数，且：
    //         50%的概率返回1
    //         25%的概率返回2
    //       12.5%的概率返回3 ...
    //Math.random() < 0.5 的概率是1/2，所以每循环一次概率乘以1/2
    private int randomLevel(){
        int level = 1;

        while(Math.random() < SKIPLIST_P && level < MAX_LEVEL){
            level += 1;
        }
        return level;
    }


    public void printAll(){
        Node p = head;
        while (p.forwards[0] !=null){
            System.out.println(p.forwards[0] + " ");
            p = p.forwards[0];
        }
        System.out.println();
    }


    public class Node {
        private int data = -1;
        private Node[] forwards = new Node[MAX_LEVEL];
        private int maxLevel = 0;
    }

}




