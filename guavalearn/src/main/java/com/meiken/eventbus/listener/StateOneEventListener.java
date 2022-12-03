package com.meiken.eventbus.listener;

import com.google.common.eventbus.Subscribe;
import com.meiken.eventbus.StateChangeEventParam;

public class StateOneEventListener {

    @Subscribe
    public void stateOneEventHandler(StateChangeEventParam param){
        System.out.println("StateOneEventListener : Handler");
    }
}
