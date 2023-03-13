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
    String visitOnEntry(StateMachine<?, ?, ?> visitable);


    /**
     *
     * @param: visitable
     * @return: java.lang.String
     **/
    String visitOnExit(StateMachine<?, ?, ?> visitable);

    /**
     *
     * @param: visitable the element to be visited
     * @return: java.lang.String
     **/
    String visitOnEntry(State<?, ?, ?> visitable);


    /**
     *
     * @param: visitable
     * @return: java.lang.String
     **/
    String visitOnExit(State<?, ?, ?> visitable);
}
