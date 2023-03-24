package org.chench.component.statemachine.builder;

import org.chench.component.statemachine.State;
import org.chench.component.statemachine.StateMachine;
import org.chench.component.statemachine.impl.StateMachineImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StateMachineBuilderImpl<S, E, C> implements StateMachineBuilder<S, E, C> {

    private final Map<S, State<S, E, C>> stateMap = new ConcurrentHashMap<>();

    private final StateMachineImpl<S, E, C> stateMachine = new StateMachineImpl<>(stateMap);

    private FailCallback<S, E, C> failCallback = new NumbFailCallback<>();

    @Override
    public ExternalTransitionBuilder<S, E, C> externalTransition() {
        return null;
    }

    @Override
    public ExternalTransitionsBuilder<S, E, C> externalTransitions() {
        return null;
    }

    @Override
    public InternalTransitionBuilder<S, E, C> internalTransition() {
        return null;
    }

    @Override
    public void setFailCallback(FailCallback<S, E, C> callback) {

    }

    @Override
    public StateMachine<S, E, C> build(String machineId) {
        return null;
    }
}
