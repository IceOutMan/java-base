package com.meiken;

import java.util.Timer;
import java.util.TimerTask;

public class Timer_Main {
    public static void main(String[] args) {
        // 抛出异常，Timer 会终止，所有任务（包括并行的其他任务)也会被终止运行
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("每2s执行一次～");
                throw new RuntimeException();
            }
        },1000, 2000);


    }
}
