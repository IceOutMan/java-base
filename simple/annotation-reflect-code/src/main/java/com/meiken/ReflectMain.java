package com.meiken;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author glf
 * @Date 2021/1/18
 */
public class ReflectMain {
    public static void main(String[] args) {
        methodReflect();
        invokeReflect();
    }
    public static void invokeReflect(){
        System.out.println("\nINVOKE REFLECT");
        try {
            Object objcet = Person.class.getConstructor().newInstance();
            Method method = Person.class.getDeclaredMethod("notAnnotationMethod", int.class, String.class);
            method.invoke(objcet,12,"IceOutMan");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
    public static void methodReflect(){
//        Method[] methods = Person.class.getMethods();
        Method[] methods = Person.class.getDeclaredMethods();
        for(Method method : methods){
            System.out.println();
            System.out.println("Method Name:" + method.getName());
            System.out.println("Method Return Type:" + method.getReturnType());
            System.out.println("Method Parameters : " + method.getParameters());
            System.out.println("Method Parameters Types : " + method.getParameterTypes());
            System.out.println("Method Annotations : " + method.getAnnotations());
            System.out.println("Method has MyAnnotation Type Annotation : " + method.isAnnotationPresent(MyAnnotation.class));

            if(method.isAnnotationPresent(MyAnnotation.class)){
                MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
                System.out.println("MyAnnotation value: "+myAnnotation.value());
            }

        }
    }
}
