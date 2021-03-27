package com.meiken;

import java.io.File;

/**
 * @Author glf
 * @Date 2021/2/2
 */
public class JavaAbality {
    public static void main(String[] args) {
        String path = "/Users/gulinfei/mydeveloper";

        long start = System.currentTimeMillis();

        search(path);

        long end = System.currentTimeMillis();
        System.out.println((end - start)/1000.0 + "s");
    }

    public static void search(String filePath){
        File file = new File(filePath);
        if(!file.exists() || file.isFile()){
            return;
        }

        if(file.isDirectory()){
            File[] fileChilds = file.listFiles();
            for(File fileChild : fileChilds){

                if(fileChild.listFiles() != null && fileChild.listFiles().length >  100){
                    new Thread( ()->{
                        search(fileChild.getAbsolutePath());
                    }).start();
                }else{
                    search(fileChild.getAbsolutePath());
                }
            }
        }
    }
}
