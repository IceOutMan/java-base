package glf.ainewbegin.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author glf
 * @Date 2021/3/12
 */
public class ShoutInvocationHandler implements InvocationHandler {

    private Object target;
    public ShoutInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("This is Proxy");
        Object result= method.invoke(target, args);
        return result;
    }
}
