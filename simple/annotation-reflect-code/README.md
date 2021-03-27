
ElementType [TYPE,FIELD,METHOD.....] 表示注解的位置，类还是方法还是属性

RetentionPolicy [SOURCE,CLASS,RUNTIEM] 注解存在作用域，RUNTIME作用域范围可被JVM加载进去，也即是运行时可以使用反射拿到注解

@interface 表示是注解类型

@Documented 可有可无，有的话注解会在生成的javac文档中
@Target
@Retention