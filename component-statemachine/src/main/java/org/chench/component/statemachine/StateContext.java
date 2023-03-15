package org.chench.component.statemachine;

public interface StateContext<S, E, C> {

    /**
     * Gets the transition
     *
     * @return
     */
    Transition<S, E, C> getTransition();

    /**
     * Gets the state machine
     *
     * @return
     */
    StateMachine<S, E, C> getStateMachine();
}
