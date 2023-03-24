package org.chench.component.statemachine.builder;

public interface InternalTransitionBuilder<S, E, C> {

    To<S, E, C> within(S stateId);
}
