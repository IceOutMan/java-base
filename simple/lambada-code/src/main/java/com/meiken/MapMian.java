package com.meiken;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class MapMian {
    public static void main(String[] args) {

        mapUse();
        mapObject();
    }
    public static void mapObject(){
        List<Item> itemList = Lists.newArrayList();
        for(int i =0; i<100; i++){
            Item item = getRandomItemList(i);
            itemList.add(item);
        }

        List<Object> otherObjectMapList = itemList.stream().map(item -> otherObjectMap(item)).collect(Collectors.toList());
        otherObjectMapList.forEach(item -> {
            System.out.println(item);
        });
    }

    public static void mapUse(){
        List<Integer> integerList = Lists.newArrayList(1,2,3,4);

        List<Integer> mapList = integerList.stream().map(item -> item * 2).collect(Collectors.toList());
        System.out.println(mapList);
    }

    private static Object otherObjectMap(Item item){
        return null;
    }

    private static Item getRandomItemList(int seed){
        Random random = new Random(seed);
        int id = random.nextInt(1000) ;

        Item item = new Item();
        item.setId(id);
        item.setName("id:"+id);
        return item;
    }

    static class Item{
        Integer id;
        String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
