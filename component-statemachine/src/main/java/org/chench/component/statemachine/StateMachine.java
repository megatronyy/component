package org.chench.component.statemachine;

/**
 * StateMachine
 *
 * @param <S> the type of state
 * @param <E> the type of event
 * @param <C> the user defined context
 * @author quwb
 */
public interface StateMachine<S, E, C> extends Visitable {

    boolean verify(S sourceStateId, E event);

    S fireEvent(S sourceState, E event, C cx);

    String getMachineId();

    /**
     * user visitor pattern to display the structure of the state machine
     **/
    void showStateMachine();

}
