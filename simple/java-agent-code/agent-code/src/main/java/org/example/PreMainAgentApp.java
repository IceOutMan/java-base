package org.example;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * Hello world!
 *
 */
public class PreMainAgentApp
{
    /**
     * 该方法在main方法之前运行，与main方法运行在同一个JVM中
     * 并被同一个System ClassLoader装载
     * 被统一的安全策略(security policy)和上下文(context)管理
     * @param agentOps
     * @param inst
     */
    public static void premain(String agentOps, Instrumentation inst){
        System.out.println("======premain(String agentOps, Instrumentation inst)======");
        System.out.println("Agent args is : " + agentOps);
        inst.addTransformer(new DefineTransformer(), true);
    }

    /**
     * * 如果不存在 premain(String agentOps, Instrumentation inst)
     * * 则会执行 premain(String agentOps)
     * @param agentOps
     */
    public static void premain(String agentOps){
        System.out.println("======premain(String agentOps)======");
    }

    static class DefineTransformer implements ClassFileTransformer {

        @Override
        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
            System.out.println("premain load class :" + className);
            return new byte[0];
        }
    }

}
