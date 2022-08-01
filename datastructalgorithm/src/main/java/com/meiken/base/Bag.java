package com.meiken.base;


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @Author glf
 * @Date 2022/6/23
 * 背包结构
 */
public class Bag<Item> implements Iterable<Item> {
    private Node<Item> first; // begining of bag
    private int n; // number of elemetn in bag

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }
    public Bag(){
        first = null;
        n = 0;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return n;
    }

    public void add(Item item){
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }


    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    @Override
    public void forEach(Consumer<? super Item> action) {
    }

    @Override
    public Spliterator<Item> spliterator() {
        return null;
    }

    private class LinkedIterator implements Iterator<Item>{
        private Node<Item> current;

        public LinkedIterator(Node<Item> first){
           current = first;
        }

        @Override
        public Item next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void forEachRemaining(Consumer<? super Item> action) {
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }
    }
}
