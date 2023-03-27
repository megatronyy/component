package org.chench.component.statemachine.builder;

public class StateMachineBuilderFactory {
    public static <S, E, C> StateMachineBuilder<S, E, C> create() {
        return new StateMachineBuilderImpl<>();
    }
}
