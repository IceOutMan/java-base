package org.example.eventbus;

import com.google.common.eventbus.EventBus;

public class EventBusMain {

    public static void main(String[] args) {
        EventBus eventBus = StateChangeEventBus.getStateChangeEventBus();

        StateChangeEventParam stateChangeEventParam = new StateChangeEventParam();
        stateChangeEventParam.setUid(1234L);
        stateChangeEventParam.setType(3);
        eventBus.post(stateChangeEventParam);

        OtherChangeEventParam otherChangeEventParam = new OtherChangeEventParam();
        otherChangeEventParam.setUid(222L);
        eventBus.post(otherChangeEventParam);

    }
}
