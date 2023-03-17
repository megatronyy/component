package org.chench.component.statemachine.impl;

import org.chench.component.statemachine.State;
import org.chench.component.statemachine.StateMachine;
import org.chench.component.statemachine.Transition;
import org.chench.component.statemachine.Visitor;

public class PlantUMLVisitor implements Visitor {
    @Override
    public String visitOnEntry(StateMachine<?, ?, ?> stateMachine) {
        return "@startuml" + LF;
    }

    @Override
    public String visitOnExit(StateMachine<?, ?, ?> stateMachine) {
        return "@enduml";
    }

    @Override
    public String visitOnEntry(State<?, ?, ?> state) {
        StringBuilder sb = new StringBuilder();
        for (Transition transition : state.getAllTransitions()) {
            sb.append(transition.getSource().getId())
                    .append(" --> ")
                    .append(transition.getTarget().getId())
                    .append(" : ")
                    .append(transition.getEvent())
                    .append(LF);
        }
        return sb.toString();
    }

    @Override
    public String visitOnExit(State<?, ?, ?> visitable) {
        return null;
    }
}
