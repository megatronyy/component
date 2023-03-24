package org.chench.component.statemachine.builder;

import org.chench.component.statemachine.Action;
import org.chench.component.statemachine.Condition;
import org.chench.component.statemachine.State;
import org.chench.component.statemachine.Transition;
import org.chench.component.statemachine.impl.StateHelper;
import org.chench.component.statemachine.impl.TransitionType;

import java.util.Map;

public class TransitionBuilderImpl<S, E, C> implements ExternalTransitionBuilder<S, E, C>,
        InternalTransitionBuilder<S, E, C>, From<S, E, C>, To<S, E, C>, On<S, E, C> {

    final Map<S, State<S, E, C>> stateMap;

    private State<S, E, C> source;

    protected State<S, E, C> target;

    private Transition<S, E, C> transition;

    final TransitionType transitionType;

    public TransitionBuilderImpl(Map<S, State<S, E, C>> stateMap, TransitionType transitionType) {
        this.stateMap = stateMap;
        this.transitionType = transitionType;
    }

    @Override
    public From from(S stateId) {

        source = StateHelper.getState(stateMap, stateId);

        return this;
    }

    @Override
    public To<S, E, C> to(S stateId) {

        target = StateHelper.getState(stateMap, stateId);

        return this;
    }

    @Override
    public To<S, E, C> within(S stateId) {

        source = target = StateHelper.getState(stateMap, stateId);

        return this;
    }

    @Override
    public When<S, E, C> when(Condition<C> condition) {

        transition.setCondition(condition);

        return this;
    }

    @Override
    public On<S, E, C> on(E event) {

        transition = source.addTransition(event, target, transitionType);

        return this;
    }

    @Override
    public void perform(Action<S, E, C> action) {
        transition.setAction(action);
    }
}
