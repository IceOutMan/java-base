使用在类
public class MyClass<T> {}
用在类上的泛型可以被里面的方法或者参数使用

仅使用在方法上
public <T,E> T typeTest(T t, E e){}
仅仅用在方法上需要单独使用<>进行约束，才可以使用在方法的参数总，而且编译器会做类型检查