package glf.ainewbegin.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author glf
 * @Date 2021/3/12
 */
public class JDKProxyApp {

    public static void main(String[] args) {
        Dog dog = new Dog();
        ShoutInvocationHandler invocationHandler = new ShoutInvocationHandler(dog);
        IShoutAction proxyObj = (IShoutAction) Proxy.newProxyInstance(IShoutAction.class.getClassLoader(), new Class[]{IShoutAction.class}, invocationHandler);
        System.out.println(proxyObj.shout());
    }
}
