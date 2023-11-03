package org.example;

import com.sun.tools.attach.*;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class UseAgentApp
{

    public static final String POST_AGENT_JAR_PATH = "/Users/xmly/IdeaProjects/java-base/simple/java-agent-code/agent-code/target/agent-code-1.0-SNAPSHOT-jar-with-dependencies.jar";
    public static void main( String[] args ) throws AgentLoadException, IOException, AgentInitializationException, AttachNotSupportedException {
        System.out.println( "this is in UseAgentApp Main" );

//        // 获取当前系统中所有 运行中的 虚拟机
        System.out.println("running JVM start ");
//        List<VirtualMachineDescriptor> list = VirtualMachine.list();
//        for (VirtualMachineDescriptor vmd : list) {
//            // 如果虚拟机的名称为 xxx 则 该虚拟机为目标虚拟机，获取该虚拟机的 pid
//            // 然后加载 agent.jar 发送给该虚拟机
//            System.out.println(vmd.displayName());
//            if (vmd.displayName().endsWith("org.example.UseAgentApp")) {
//                VirtualMachine virtualMachine = VirtualMachine.attach(vmd.id());
//                virtualMachine.loadAgent(POST_AGENT_JAR_PATH);
//                virtualMachine.detach();
//            }
//        }
    }
}
