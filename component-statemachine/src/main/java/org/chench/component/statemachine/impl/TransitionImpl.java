package org.chench.component.statemachine.impl;

import org.chench.component.statemachine.Action;
import org.chench.component.statemachine.Condition;
import org.chench.component.statemachine.State;
import org.chench.component.statemachine.Transition;

public class TransitionImpl<S, E, C> implements Transition<S, E, C> {
    private State<S, E, C> source;
    private State<S, E, C> target;
    private E event;
    private Condition<C> condition;
    private Action<S, E, C> action;
    private TransitionType type = TransitionType.EXTERNAL;

    @Override
    public State<S, E, C> getSource() {
        return this.source;
    }

    @Override
    public void setSource(State<S, E, C> state) {
        this.source = source;
    }

    @Override
    public E getEvent() {
        return this.event;
    }

    @Override
    public void setEvent(E event) {
        this.event = event;
    }

    @Override
    public void setType(TransitionType type) {
        this.type = type;
    }

    @Override
    public State<S, E, C> getTarget() {
        return this.target;
    }

    @Override
    public void setTarget(State<S, E, C> state) {
        this.target = target;
    }

    @Override
    public Condition<C> getCondition() {
        return this.condition;
    }

    @Override
    public void setCondition(Condition<C> condition) {
        this.condition = condition;
    }

    @Override
    public Action<S, E, C> getAction() {
        return this.action;
    }

    @Override
    public void setAction(Action<S, E, C> action) {
        this.action = action;
    }

    @Override
    public State<S, E, C> transit(C ctx, boolean checkCondition) {

        Debuger.debug("Do transition: " + this);

        this.verify();

        if (!checkCondition || condition == null || condition.isStatisfied(ctx)) {
            if (action != null) {
                action.execute(this.source.getId(), this.target.getId(), event, ctx);
            }

            return target;
        }

        Debuger.debug("Condition is not satisfied, stay at the "+source+" state ");

        return source;
    }

    @Override
    public void verify() {
        if(type== TransitionType.INTERNAL && source != target) {
            throw new StateMachineException(String.format("Internal transition source state '%s' " +
                    "and target state '%s' must be same.", source, target));
        }
    }

    @Override
    public final String toString() {
        return source + "-[" + event.toString() + ", " + type + "]->" + target;
    }

    @Override
    public boolean equals(Object anObject){
        if(anObject instanceof Transition){
            Transition other = (Transition)anObject;
            if(this.event.equals(other.getEvent())
                    && this.source.equals(other.getSource())
                    && this.target.equals(other.getTarget())){
                return true;
            }
        }
        return false;
    }
}
