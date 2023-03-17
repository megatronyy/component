package org.chench.component.statemachine.impl;

import org.chench.component.statemachine.State;

import java.util.Map;

/**
 * StateHelper
 *
 * @Author: quwb
 * @CreateTime: 2023-03-16  09:58
 * @Version: 1.0
 */
public class StateHelper {
    public static <S, E, C> State<S, E, C> getState(Map<S, State<S, E, C>> stateMap, S stateId) {
        State<S, E, C> state = stateMap.get(stateId);

        if (state == null) {
            state = new StateImpl<>(stateId);
            stateMap.put(stateId, state);
        }

        return state;
    }
}
