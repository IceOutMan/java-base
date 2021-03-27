package glf.ainewbegin.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @Author glf
 * @Date 2021/3/12
 */
public class CglibApp {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dog.class);
        enhancer.setCallback(new MyMethodInterceptor());

        Dog dog = (Dog) enhancer.create();
        System.out.println(dog.shout());
    }
}
