package org.chench.component.statemachine;

public interface Action<S, E, C> {

    /**
     * Execute action with a {@link StateContext}
     * @param from
     * @param to
     * @param event
     * @param context
     */
    public void execute(S from, S to, E event, C context);
}
