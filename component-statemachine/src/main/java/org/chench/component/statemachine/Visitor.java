package org.chench.component.statemachine;

/**
 * Visitor
 *
 * @author quwb
 * @date 2023-03-13 14:21
 */
public interface Visitor {

    char LF = '\n';

    /**
     *
     * @param: visitable the element to be visited
     * @return: java.lang.String
     **/
    String visitOnEntry(StateMachine<?, ?, ?> stateMachine);


    /**
     *
     * @param: visitable
     * @return: java.lang.String
     **/
    String visitOnExit(StateMachine<?, ?, ?> stateMachine);

    /**
     *
     * @param: visitable the element to be visited
     * @return: java.lang.String
     **/
    String visitOnEntry(State<?, ?, ?> state);


    /**
     *
     * @param: visitable
     * @return: java.lang.String
     **/
    String visitOnExit(State<?, ?, ?> visitable);
}
