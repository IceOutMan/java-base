package org.example.eventbus.listener;

import com.google.common.eventbus.Subscribe;
import org.example.eventbus.StateChangeEventParam;

public class StateTwoEventListener {

    @Subscribe
    public void stateTwoEventHandler(StateChangeEventParam param){
        System.out.println("StateTwoEventListener : Handler");
    }
}
