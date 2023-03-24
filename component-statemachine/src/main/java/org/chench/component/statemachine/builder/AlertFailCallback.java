package org.chench.component.statemachine.builder;

import org.chench.component.statemachine.exception.TransitionFailException;

public class AlertFailCallback<S, E, C> implements FailCallback<S, E, C> {
    @Override
    public void onFail(S sourceState, E event, C context) {
        throw new TransitionFailException(
                "Cannot fire event [" + event + "] on current state [" + context + "]"
        );
    }
}
