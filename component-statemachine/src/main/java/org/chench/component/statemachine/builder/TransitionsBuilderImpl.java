package org.chench.component.statemachine.builder;

import org.chench.component.statemachine.Action;
import org.chench.component.statemachine.Condition;
import org.chench.component.statemachine.State;
import org.chench.component.statemachine.Transition;
import org.chench.component.statemachine.impl.StateHelper;
import org.chench.component.statemachine.impl.TransitionType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransitionsBuilderImpl<S, E, C> extends TransitionBuilderImpl<S, E, C>
        implements ExternalTransitionsBuilder<S, E, C> {

    private List<State<S, E, C>> sources = new ArrayList<>();

    private List<Transition<S, E, C>> transitions = new ArrayList<>();

    public TransitionsBuilderImpl(Map<S, State<S, E, C>> stateMap, TransitionType transitionType) {
        super(stateMap, transitionType);
    }

    @Override
    public From<S, E, C> fromAmong(S... stateIds) {
        for (S stateId : stateIds) {
            sources.add(StateHelper.getState(super.stateMap, stateId));
        }

        return this;
    }

    @Override
    public On<S, E, C> on(E event) {
        for (State source : sources) {
            Transition transition = source.addTransition(event, super.target, super.transitionType);
            transitions.add(transition);
        }
        return this;
    }

    @Override
    public When<S, E, C> when(Condition<C> condition) {

        for (Transition transition : transitions) {
            transition.setCondition(condition);
        }

        return this;
    }

    @Override
    public void perform(Action<S, E, C> action) {
        for (Transition transition : transitions) {
            transition.setAction(action);
        }
    }
}
