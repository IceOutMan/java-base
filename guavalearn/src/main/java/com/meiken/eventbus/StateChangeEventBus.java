package com.meiken.eventbus;

import com.google.common.eventbus.EventBus;
import com.meiken.eventbus.listener.OtherEventListener;
import com.meiken.eventbus.listener.StateOneEventListener;
import com.meiken.eventbus.listener.StateTwoEventListener;

public class StateChangeEventBus {

    private static EventBus stateChangeEventBus = new EventBus();

    public static EventBus getStateChangeEventBus(){
        stateChangeEventBus.register(new StateOneEventListener());
        stateChangeEventBus.register(new StateTwoEventListener());
        stateChangeEventBus.register(new OtherEventListener());
        return stateChangeEventBus;
    }

}
