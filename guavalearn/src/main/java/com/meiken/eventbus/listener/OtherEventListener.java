package com.meiken.eventbus.listener;

import com.google.common.eventbus.Subscribe;
import com.meiken.eventbus.OtherChangeEventParam;

public class OtherEventListener {
    @Subscribe
    public void stateOneEventHandler(OtherChangeEventParam param){
        System.out.println("OtherChangeEventListener : Handler");
    }
}
