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

    /**
     * Verify if an event {@code E} can be fired from current state {@code S}
     *
     * @param sourceStateId
     * @param event
     * @return
     */
    boolean verify(S sourceStateId, E event);

    /**
     * Send an event {@code E} to the state machine.
     *
     * @param sourceState
     * @param event
     * @param cx
     * @return
     */
    S fireEvent(S sourceState, E event, C cx);

    /**
     * MachineId is the identifier for a State Machine
     *
     * @return
     */
    String getMachineId();

    /**
     * user visitor pattern to display the structure of the state machine
     **/
    void showStateMachine();

    String generatePlantUML();

}
