package org.example.eventbus.listener;

import com.google.common.eventbus.Subscribe;
import org.example.eventbus.OtherChangeEventParam;

public class OtherEventListener {
    @Subscribe
    public void stateOneEventHandler(OtherChangeEventParam param){
        System.out.println("OtherChangeEventListener : Handler");
    }
}
