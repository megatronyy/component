package org.chench.component.statemachine.impl;

import org.chench.component.statemachine.Transition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * EventTransitions
 * <p>
 * 同一个Event可以触发多个Transition
 *
 * @param <S>
 * @param <E>
 * @param <C>
 */
public class EventTransitions<S, E, C> {
    private HashMap<E, List<Transition<S, E, C>>> eventTransitions;

    public EventTransitions() {
        eventTransitions = new HashMap<>();
    }

    public void put(E event, Transition<S, E, C> transition) {
        if (eventTransitions.get(event) == null) {
            List<Transition<S, E, C>> transitions = new ArrayList<>();
            transitions.add(transition);
            eventTransitions.put(event, transitions);
        } else {
            List existingTransitions = eventTransitions.get(event);
            verify(existingTransitions, transition);
            existingTransitions.add(transition);
        }
    }

    private void verify(List<Transition<S, E, C>> exsitingTransitions, Transition<S, E, C> newTransition) {
        for (Transition transition : exsitingTransitions) {
            if (newTransition.equals(transition)) {
                throw new StateMachineException(transition + " already Exist, you can not add another one");
            }
        }
    }

    public List<Transition<S, E, C>> get(E event) {
        return eventTransitions.get(event);
    }

    public List<Transition<S, E, C>> allTransitions() {
        List<Transition<S, E, C>> allTransitions = new ArrayList<>();
        for (List<Transition<S, E, C>> transitions : eventTransitions.values()) {
            allTransitions.addAll(transitions);
        }

        return allTransitions;
    }
}
