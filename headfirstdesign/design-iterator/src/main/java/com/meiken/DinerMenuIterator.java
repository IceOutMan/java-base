package com.meiken;

public class DinerMenuIterator implements Iterator{
    Object[] list;
    int position = 0;

    public DinerMenuIterator(Object[] list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if(position >= list.length || list[position] == null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public Object next() {
        Object obj = list[position];
        position = position+1;
        return obj;
    }

    @Override
    public void remove() {
        if(position <= 0){
            throw new IllegalArgumentException("You can't remove an item until you've done at least one next()");
        }
        if(list[position - 1] != null){
            for (int i = 0; i < list.length - 1; i++) {
                list[i] = list[i+1];
            }
            list[list.length - 1] = null;
        }
    }
}
