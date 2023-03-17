package org.chench.component.statemachine.impl;

import org.chench.component.statemachine.State;
import org.chench.component.statemachine.Transition;
import org.chench.component.statemachine.Visitor;

import java.util.Collection;
import java.util.List;

/**
 * TODO
 *
 * @Author: quwb
 * @CreateTime: 2023-03-16  10:03
 * @Version: 1.0
 */
public class StateImpl<S, E, C> implements State<S, E, C> {

    private final S stateId;

    StateImpl(S stateId) {
        this.stateId = stateId;
    }

    @Override
    public S getId() {
        return null;
    }

    @Override
    public Transition<S, E, C> addTransition(E event, State<S, E, C> target, TransitionType transitionType) {
        return null;
    }

    @Override
    public List<Transition<S, E, C>> getEventTransitions(E event) {
        return null;
    }

    @Override
    public Collection<Transition<S, E, C>> getAllTransitions() {
        return null;
    }

    @Override
    public String accept(Visitor visitor) {
        return null;
    }
}
