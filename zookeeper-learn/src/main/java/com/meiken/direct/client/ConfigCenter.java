package com.meiken.direct.client;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ConfigCenter {

    private final static String CONNECT_STR = "127.0.0.1:2181";
    private final static Integer SESSION_TIMEOUT = 30 * 1000;

    private final static String MEIKEN_NODE = "/meiken_node";

    private static ZooKeeper zooKeeper = null;

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        // zk 创建连接是 通过守护线程进行异步连接 。主线程不能立马结束
        zooKeeper = new ZooKeeper(CONNECT_STR, SESSION_TIMEOUT, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getType() == Event.EventType.None
                        && watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    // 连接成功
                    System.out.println("连接成功!");
                    countDownLatch.countDown();
                }
            }
        });

        countDownLatch.await();

        String configValue = "{ 'name' : 'zhangsan', 'age': 2}";
        // 新增一个节点
        zooKeeper.create("/meiken_node", configValue.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);


        Watcher dataChangeWatcher = new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if(watchedEvent.getType() == Event.EventType.NodeDataChanged
                        && watchedEvent.getPath() != null && watchedEvent.getPath().equals("/meiken_node")){
                    System.out.println("[/meiken_node] 数据发生了变化");
                    try {
                        byte[] data = zooKeeper.getData(MEIKEN_NODE, this, null);
                        System.out.println("数据发生变化后为:" + new String(data));
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };

        byte[] data = zooKeeper.getData(MEIKEN_NODE, dataChangeWatcher, null);
        System.out.println("数据发生变化前为:" + new String(data));

        Thread.sleep( 5 * 60 * 1000);
    }
}
