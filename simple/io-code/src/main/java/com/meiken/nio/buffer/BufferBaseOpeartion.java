package com.meiken.nio.buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * Buffer的基本操作
 * 1. mark
 * 2. position
 * 3. limit
 * 4. capacity
 */
public class BufferBaseOpeartion {

    public static void main(String[] args) {

        operation_put();

        operation_flip();

        operation_get();

        operation_clear();

        operation_compact();

        operation_mark_reset();
    }



    // put stuff to Buffer
    public static void operation_put(){
        System.out.println("\nMethod: operation_put");
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        printPositionAndLimit(byteBuffer);

        byteBuffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o');
        // H e l l o X X X X X X
        // 0 1 2 3 4 5 6 7 8 9 10
        // mark = -1, position = 5, limit = 10, capacity = 10

        printPositionAndLimit(byteBuffer);

        byteBuffer.put(0,(byte)'M').put((byte)'w');
        // M e l l o w X X X X X
        // 0 1 2 3 4 5 6 7 8 9 10
        // mark = -1, position = 6, limit = 10, capacity = 10

        printPositionAndLimit(byteBuffer);
    }

    // flip
    public static void operation_flip(){
        System.out.println("\nMethod: operation_flip");

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        printPositionAndLimit(byteBuffer);

        byteBuffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o');
        // H e l l o X X X X X X
        // 0 1 2 3 4 5 6 7 8 9 10
        // mark = -1, position = 5, limit = 10, capacity = 10
        printPositionAndLimit(byteBuffer);

        byteBuffer.flip();
        // H e l l o X X X X X X
        // 0 1 2 3 4 5 6 7 8 9 10
        // mark = -1, position = 0, limit = 5, capacity = 10
        printPositionAndLimit(byteBuffer);
    }

    public static void operation_get(){
        System.out.println("\nMethod: operation_get");

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        printPositionAndLimit(byteBuffer);

        byteBuffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o');
        // H e l l o X X X X X X
        // 0 1 2 3 4 5 6 7 8 9 10
        // mark = -1, position = 5, limit = 10, capacity = 10
        printPositionAndLimit(byteBuffer);

        byteBuffer.flip();
        while(byteBuffer.hasRemaining()){
            System.out.print((char)byteBuffer.get() + "");
        }
        System.out.println();
        printPositionAndLimit(byteBuffer);
    }

    public static void operation_clear(){
        System.out.println("\nMethod: operation_clear");

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        printPositionAndLimit(byteBuffer);

        byteBuffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o');
        // H e l l o X X X X X X
        // 0 1 2 3 4 5 6 7 8 9 10
        // mark = -1, position = 5, limit = 10, capacity = 10
        printPositionAndLimit(byteBuffer);

        byteBuffer.clear();
        printPositionAndLimit(byteBuffer);
    }

    // drop readed data, remaint unread data,  limit == capacity
    public static void operation_compact(){
        System.out.println("\nMethod: operation_compact");

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        printPositionAndLimit(byteBuffer);

        byteBuffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o');
        // H e l l o X X X X X X
        // 0 1 2 3 4 5 6 7 8 9 10
        // mark = -1, position = 5, limit = 10, capacity = 10
        printPositionAndLimit(byteBuffer);

        byteBuffer.flip();
        byteBuffer.get();byteBuffer.get();
        // H e l l o X X X X X X
        // 0 1 2 3 4 5 6 7 8 9 10
        // mark = -1, position = 2, limit = 5, capacity = 10
        printPositionAndLimit(byteBuffer);

        byteBuffer.compact();
        printPositionAndLimit(byteBuffer);
    }


    private static void operation_mark_reset() {
        System.out.println("\nMethod: operation_mark_reset");

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        printPositionAndLimit(byteBuffer);

        byteBuffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o');
        // H e l l o X X X X X X
        // 0 1 2 3 4 5 6 7 8 9 10
        // mark = -1, position = 5, limit = 10, capacity = 10
        printPositionAndLimit(byteBuffer);

        byteBuffer.position(2).mark().position(4);
        // H e l l o X X X X X X
        // 0 1 2 3 4 5 6 7 8 9 10
        // mark = 2, position = 4 , limit = 10, capacity = 10
        printPositionAndLimit(byteBuffer);

        byteBuffer.reset();
        // H e l l o X X X X X X
        // 0 1 2 3 4 5 6 7 8 9 10
        // mark = 2, position = 2 , limit = 10, capacity = 10
        printPositionAndLimit(byteBuffer);
    }




    private static void printPositionAndLimit(Buffer buffer){
        System.out.println("Position:" + buffer.position() + " Limit:" + buffer.limit());
    }

}
