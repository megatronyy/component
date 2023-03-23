package org.chench.component.statemachine.builder;

public interface From<S, E, C> {
    To<S, E, C> to(S stateId);
}
