package org.chench.component.statemachine;

import org.chench.component.statemachine.impl.TransitionType;

import java.util.Collection;
import java.util.List;

public interface State<S, E, C> extends Visitable {

    S getId();

    Transition<S, E, C> addTransition(E event, State<S, E, C> target, TransitionType transitionType);

    List<Transition<S, E, C>> getEventTransitions(E event);

    Collection<Transition<S, E, C>> getAllTransitions();


}
