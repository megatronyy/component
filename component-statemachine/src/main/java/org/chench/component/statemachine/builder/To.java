package org.chench.component.statemachine.builder;

public interface To<S, E, C> {

    /**
     * 构建Transitioin event
     *
     * @param event
     * @return
     */
    On<S, E, C> on(E event);
}
