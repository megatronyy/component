package org.chench.component.statemachine.builder;

import org.chench.component.statemachine.Condition;

public interface On<S, E, C> {

    /**
     * 为Transition添加Condition属性
     *
     * @param condition
     * @return
     */
    When<S, E, C> when(Condition<C> condition);
}
