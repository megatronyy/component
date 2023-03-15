package org.chench.component.statemachine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StateMachineFactory {
    static Map<String /* machineId */, StateMachine> stateMachineMap = new ConcurrentHashMap<>();

    public static <S, E, C> void register(StateMachine<S, E, C> stateMachine) {
        String machineId = stateMachine.getMachineId();

        if (stateMachineMap.get(machineId) != null) {

        }

        stateMachineMap.put(stateMachine.getMachineId(), stateMachine);
    }

    public static <S, E, C> StateMachine<S, E, C> get(String machineId) {
        StateMachine stateMachine = stateMachineMap.get(machineId);
        if (stateMachine == null) {

        }

        return stateMachine;
    }
}
