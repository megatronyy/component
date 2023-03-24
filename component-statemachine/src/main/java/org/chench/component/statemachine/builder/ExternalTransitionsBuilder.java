package org.chench.component.statemachine.builder;

public interface ExternalTransitionsBuilder<S, E, C> {
    From<S, E, C> fromAmong(S... stateIds);
}
