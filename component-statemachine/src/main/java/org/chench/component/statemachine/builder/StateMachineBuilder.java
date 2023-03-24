package org.chench.component.statemachine.builder;

import org.chench.component.statemachine.StateMachine;

public interface StateMachineBuilder<S, E, C> {

    ExternalTransitionBuilder<S, E, C> externalTransition();

    ExternalTransitionsBuilder<S, E, C> externalTransitions();

    InternalTransitionBuilder<S, E, C> internalTransition();

    void setFailCallback(FailCallback<S, E, C> callback);

    StateMachine<S, E, C> build(String machineId);
}
