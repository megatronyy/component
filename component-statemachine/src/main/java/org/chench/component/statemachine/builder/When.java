package org.chench.component.statemachine.builder;

import org.chench.component.statemachine.Action;

public interface When<S, E, C> {

    /**
     * 定义transition期间要执行的Action
     *
     * @param action
     */
    void perform(Action<S, E, C> action);
}
