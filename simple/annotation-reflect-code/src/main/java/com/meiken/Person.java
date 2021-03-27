package com.meiken;

/**
 * @Author glf
 * @Date 2021/1/18
 */
public class Person {

    @MyAnnotation(value = "myAnnotation")
    public void annotationMethod(){
        System.out.println("annotationMethod");
    }

    public boolean notAnnotationMethod(int num,String name){
        System.out.println("Name:" + name + ", age: "+ num);
        return true;
    }
}
