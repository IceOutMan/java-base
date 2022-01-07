package com.meiken;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class FilterMain {
    public static void main(String[] args) {
        filterUse();
        filterObject();
    }

    public static void filterUse(){
        List<Integer> integerList = Lists.newArrayList(1,2,3,4);

        List<Integer> filterList = integerList.stream().filter(item -> item % 2 == 0).collect(Collectors.toList());
        System.out.println(filterList);
    }
    public static void filterObject(){
        List<Item> itemList = Lists.newArrayList();
        for(int i =0; i<100; i++){
            Item item = getRandomItemList(i);
            itemList.add(item);
        }

        List<Item> filterItemList = itemList.stream().filter(item -> item.getId() % 2 == 0).collect(Collectors.toList());
        filterItemList.forEach(item -> {
            System.out.println(item.name);
        });
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
