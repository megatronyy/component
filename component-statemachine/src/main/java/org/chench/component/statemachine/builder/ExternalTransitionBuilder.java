package org.chench.component.statemachine.builder;

public interface ExternalTransitionBuilder<S, E, C> {

    /**
     * Build transition source state.
     *
     * @param stateId
     * @return
     */
    From<S, E, C> from(S stateId);
}
