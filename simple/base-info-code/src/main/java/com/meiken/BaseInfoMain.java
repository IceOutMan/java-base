package com.meiken;

import java.util.LinkedHashMap;

/**
 * Hello world!
 *
 */
public class BaseInfoMain
{
    private static LinkedHashMap<String,String> baseInfoHashMap = new LinkedHashMap<>();

    public static void main(String[] args) {
        initMap();

        baseInfoHashMap.forEach((key,value) -> {
            System.out.println(key + " :" + value + " : " + System.getProperty(key));
        });
    }

    private static void initMap() {
        baseInfoHashMap.put("java.version","Java运行时环境版本");
        baseInfoHashMap.put("java.vendor","Java供应商");
        baseInfoHashMap.put("java.vendor.url","Java供应商的URL");
        baseInfoHashMap.put("java.home","Java的安装目录");
        baseInfoHashMap.put("java.vm.specification.version","Java虚拟机规范版本");
        baseInfoHashMap.put("java.vm.specification.vendor","Java虚拟机规范供应商");
        baseInfoHashMap.put("java.vm.specification.name","Java虚拟机规范名称");
        baseInfoHashMap.put("java.vm.version","Java虚拟机实现版本");
        baseInfoHashMap.put("java.vm.vendor","Java虚拟机实现供应商");
        baseInfoHashMap.put("java.vm.name","Java虚拟机实现名称");
        baseInfoHashMap.put("java.specification.version","Java运行时环境规范版本");
        baseInfoHashMap.put("java.specification.vendor","Java运行时环境规范供应商");
        baseInfoHashMap.put("java.specification.name","Java运行时环境规范名称");
        baseInfoHashMap.put("java.class.version","Java类格式版本号");
        baseInfoHashMap.put("java.class.path","Java类路径");
        baseInfoHashMap.put("java.library.path","Java加载库时搜索的路径列表");
        baseInfoHashMap.put("java.io.tmpdir","Java默认的临时文件路径");
        baseInfoHashMap.put("java.complier","Java要使用的JIT编译器的名称");
        baseInfoHashMap.put("java.ext.dirs","Java一个或多个扩展目录的路径");
        baseInfoHashMap.put("os.name","操作系统的名称");
        baseInfoHashMap.put("os.arch","操作系统的架构");
        baseInfoHashMap.put("os.version","操作系统的版本");
        baseInfoHashMap.put("file.separator","文件分隔符");
        baseInfoHashMap.put("user.name","用户的账户名称");
        baseInfoHashMap.put("user.home","用户的目录");
        baseInfoHashMap.put("user.dir","用户的当前工作目录");
    }

}
