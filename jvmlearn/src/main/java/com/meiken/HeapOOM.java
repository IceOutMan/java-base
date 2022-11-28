package com.meiken.c2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author glf
 * @Date 2022/5/5
 */
public class HeapOOM {
    static class OOMObject{
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }

//        HeapDumpOnOutOfMemoryError
//        HeapDumpOnOutOfMemroryEerror
    }
}
