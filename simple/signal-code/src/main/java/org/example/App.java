package org.example;

import sun.misc.Signal;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        // TERM 对应 15
        // kill -15 pid
        Signal signal = new Signal("TERM");
        Signal.handle(signal, (sig) -> {
            System.out.println("Signal handle start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Signal handle end");
        });

        Thread.sleep(1000 * 60);
    }
}
