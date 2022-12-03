package com.meiken;

/**
 * Hello world!
 *
 */
public class TypesMain
{
    public static void main( String[] args )
    {
        classTypeTest();
        methodTypeTest();
    }

    public static void classTypeTest(){
        System.out.println("CLASS TYPE TEST");
        MyClassType<Integer> object = new MyClassType<>();
//        object.printT(new String(""));//编译不通过
        object.printT(2);
    }
    public static void methodTypeTest(){
        System.out.println("METHOD TYPE TEST");
        MyMethodType object = new MyMethodType();
        Integer result = object.methodType(2);
        String strResult = object.methodType("str test");
    }
}
