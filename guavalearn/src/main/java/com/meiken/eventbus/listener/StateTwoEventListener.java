package com.meiken.eventbus.listener;

import com.google.common.eventbus.Subscribe;
import com.meiken.eventbus.StateChangeEventParam;

public class StateTwoEventListener {

    @Subscribe
    public void stateTwoEventHandler(StateChangeEventParam param){
        System.out.println("StateTwoEventListener : Handler");
    }
}
