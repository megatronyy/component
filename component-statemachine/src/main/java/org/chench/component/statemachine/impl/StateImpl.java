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

    private EventTransitions eventTransitions = new EventTransitions();

    StateImpl(S stateId) {
        this.stateId = stateId;
    }

    @Override
    public S getId() {
        return this.stateId;
    }

    @Override
    public Transition<S, E, C> addTransition(E event, State<S, E, C> target, TransitionType transitionType) {
        Transition<S, E, C> newTransition = new TransitionImpl<>();
        newTransition.setSource(this);
        newTransition.setTarget(target);
        newTransition.setEvent(event);
        newTransition.setType(transitionType);

        Debuger.debug("Begin to add new transition: " + newTransition);

        eventTransitions.put(event, newTransition);
        return newTransition;
    }

    @Override
    public List<Transition<S, E, C>> getEventTransitions(E event) {
        return eventTransitions.get(event);
    }

    @Override
    public Collection<Transition<S, E, C>> getAllTransitions() {
        return eventTransitions.allTransitions();
    }

    @Override
    public String accept(Visitor visitor) {
        String entry = visitor.visitOnEntry(this);
        String exit = visitor.visitOnExit(this);
        return entry + exit;
    }

    @Override
    public boolean equals(Object anObject) {
        if (anObject instanceof State) {
            State other = (State) anObject;
            if (this.stateId.equals(other.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return stateId.toString();
    }
}
