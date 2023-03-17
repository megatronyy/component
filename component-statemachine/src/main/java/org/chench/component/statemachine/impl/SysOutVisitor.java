package org.chench.component.statemachine.impl;

import org.chench.component.statemachine.State;
import org.chench.component.statemachine.StateMachine;
import org.chench.component.statemachine.Transition;
import org.chench.component.statemachine.Visitor;

/**
 * TODO
 *
 * @Author: quwb
 * @CreateTime: 2023-03-16  09:29
 * @Version: 1.0
 */
public class SysOutVisitor implements Visitor {
    @Override
    public String visitOnEntry(StateMachine<?, ?, ?> stateMachine) {
        String entry = "-----StateMachine:" + stateMachine.getMachineId() + "-------";
        System.out.println(entry);
        return entry;
    }

    @Override
    public String visitOnExit(StateMachine<?, ?, ?> stateMachine) {
        String exit = "------------------------";
        System.out.println(exit);
        return exit;
    }

    @Override
    public String visitOnEntry(State<?, ?, ?> state) {
        StringBuilder sb = new StringBuilder();
        String stateStr = "State:" + state.getId();
        sb.append(stateStr).append(LF);
        System.out.println(stateStr);
        for (Transition transition : state.getAllTransitions()) {
            String transitionStr = "    Transition:" + transition;
            sb.append(transitionStr).append(LF);
            System.out.println(transitionStr);
        }
        return sb.toString();
    }

    @Override
    public String visitOnExit(State<?, ?, ?> visitable) {
        return "";
    }
}
