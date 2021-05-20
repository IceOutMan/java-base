package org.example.collections;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/**
 * @Author glf
 * @Date 2021/1/14
 */
public class CollectionMain {

    public static void main(String[] args) throws InterruptedException {

        lists();
        sets();
        maps();

        Cache<String,String> cache = CacheBuilder.newBuilder().maximumSize(100).expireAfterAccess(5, TimeUnit.SECONDS).build();
        cache.put("a","1");
        System.out.println(cache.getIfPresent("a"));
        Thread.sleep(3000);
        System.out.println(cache.getIfPresent("a"));
        Thread.sleep(5000);
        System.out.println(cache.getIfPresent("a"));
    }

    public static void commonCollections(){

        Integer[] intArray = new Integer[]{11,22,33};

        System.out.println(Lists.newArrayList(1, 2, 3, 4, 5));
        System.out.println(Lists.newArrayList(intArray));
        System.out.println( Lists.asList(1,2, intArray));

        System.out.println(Sets.newHashSet(1, 2, 3, 1, 2, 5));


        HashMap<Integer,Integer> map = Maps.newHashMap();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
    }

    public static void lists(){
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5, 6);

        System.out.println(integers);
    }
    public static void sets(){
        HashSet<Object> hashSet = Sets.newHashSet();
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");
        hashSet.add("1");
        System.out.println(hashSet);


        Multiset<Object> hashMultiset = HashMultiset.create();
        hashMultiset.add("1");
        hashMultiset.add("2");
        hashMultiset.add("3");
        hashMultiset.add("1");
        System.out.println(hashMultiset.elementSet());
        System.out.println(hashMultiset.count("1"));

    }
    public static void maps(){
        HashMap<Object, Object> hashMap = Maps.newHashMap();
        hashMap.put("a",1);
        hashMap.put("b",2);
        hashMap.put("a",1);
        System.out.println(hashMap);

        HashMultimap<Object, Object> hashMultimap = HashMultimap.create();
        hashMultimap.put("a",1);
        hashMultimap.put("b",2);

        hashMultimap.put("a",2);
        hashMultimap.put("a",2);
        System.out.println(hashMultimap);
        System.out.println(hashMultimap.asMap().get("a"));
    }
}
