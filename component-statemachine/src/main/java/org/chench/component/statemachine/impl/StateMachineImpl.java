package org.chench.component.statemachine.impl;

import org.chench.component.statemachine.State;
import org.chench.component.statemachine.StateMachine;
import org.chench.component.statemachine.Transition;
import org.chench.component.statemachine.Visitor;
import org.chench.component.statemachine.builder.FailCallback;

import java.util.List;
import java.util.Map;

public class StateMachineImpl<S, E, C> implements StateMachine<S, E, C> {

    private String machineId;

    private final Map<S, State<S, E, C>> stateMap;

    private boolean ready;

    private FailCallback<S, E, C> failCallback;

    public StateMachineImpl(Map<S, State<S, E, C>> stateMap) {
        this.stateMap = stateMap;
    }

    @Override
    public boolean verify(S sourceStateId, E event) {
        isReady();

        State sourceState = getState(sourceStateId);

        List<Transition<S, E, C>> tranitions = sourceState.getEventTransitions(event);

        return tranitions != null && tranitions.size() != 0;
    }

    @Override
    public S fireEvent(S sourceStateId, E event, C ctx) {
        isReady();
        Transition<S, E, C> transition = routeTransition(sourceStateId, event, ctx);

        if (transition == null) {
            Debuger.debug("没有此event对应的transition");
            failCallback.onFail(sourceStateId, event, ctx);
            return sourceStateId;
        }

        return transition.transit(ctx, false).getId();
    }

    @Override
    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    @Override
    public void showStateMachine() {
        SysOutVisitor sysOutVisitor = new SysOutVisitor();
        accept(sysOutVisitor);
    }

    @Override
    public String generatePlantUML() {
        PlantUMLVisitor plantUMLVisitor = new PlantUMLVisitor();
        return accept(plantUMLVisitor);
    }

    @Override
    public String accept(Visitor visitor) {
        StringBuilder sb = new StringBuilder();
        sb.append(visitor.visitOnEntry(this));
        for (State state : stateMap.values()) {
            sb.append(state.accept(visitor));
        }
        sb.append(visitor.visitOnExit(this));
        return sb.toString();
    }

    private Transition<S, E, C> routeTransition(S sourceStateId, E event, C ctx) {
        State sourceState = getState(sourceStateId);
        List<Transition<S, E, C>> transitions = sourceState.getEventTransitions(event);
        if (transitions == null || transitions.size() == 0) {
            return null;
        }

        Transition<S, E, C> transit = null;
        for (Transition<S, E, C> transition : transitions) {
            if (transition.getCondition() == null) {
                transit = transition;
            } else if (transition.getCondition().isStatisfied(ctx)) {
                transit = transition;
                break;
            }
        }
        return transit;
    }

    private State getState(S currentStateId) {
        State state = StateHelper.getState(stateMap, currentStateId);
        if (state == null) {
            showStateMachine();
            throw new StateMachineException("未发现 " + currentStateId + ", 请检查StateMachine");
        }
        return state;
    }

    private void isReady() {
        if (!ready) {
            throw new StateMachineException("状态机未构建，无法工作");
        }
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public void setFailCallback(FailCallback<S, E, C> failCallback) {
        this.failCallback = failCallback;
    }
}
