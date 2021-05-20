package org.example.collections;

import com.google.common.collect.HashBasedTable;

public class TableMain {
    public static void main(String[] args) {
        HashBasedTable<Object, Object, Object> table = HashBasedTable.create();
        table.put(1,"name","zs");
        table.put(2,"name","ls");
        table.put(3,"name","ww");

        System.out.println(table.get(1, "name"));
        System.out.println(table.get(2, "name"));
        System.out.println(table.get(3, "name"));

    }
}
