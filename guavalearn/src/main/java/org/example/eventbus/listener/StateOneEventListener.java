package org.example.eventbus.listener;

import com.google.common.eventbus.Subscribe;
import org.example.eventbus.StateChangeEventParam;

public class StateOneEventListener {

    @Subscribe
    public void stateOneEventHandler(StateChangeEventParam param){
        System.out.println("StateOneEventListener : Handler");
    }
}
