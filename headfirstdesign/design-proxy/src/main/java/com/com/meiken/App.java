package com.com.meiken;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        GumballMachine machine = new GumballMachine("上海",10);

        GumballMonitor monitor = new GumballMonitor(machine);

        monitor.report();
    }
}
