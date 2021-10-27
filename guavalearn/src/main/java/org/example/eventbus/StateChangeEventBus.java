package org.example.eventbus;

import com.google.common.eventbus.EventBus;
import org.example.eventbus.listener.OtherEventListener;
import org.example.eventbus.listener.StateOneEventListener;
import org.example.eventbus.listener.StateTwoEventListener;

public class StateChangeEventBus {

    private static EventBus stateChangeEventBus = new EventBus();

    public static EventBus getStateChangeEventBus(){
        stateChangeEventBus.register(new StateOneEventListener());
        stateChangeEventBus.register(new StateTwoEventListener());
        stateChangeEventBus.register(new OtherEventListener());
        return stateChangeEventBus;
    }

}
