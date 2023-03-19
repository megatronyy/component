package org.chench.component.statemachine.builder;

public interface FailCallback<S, E, C> {

    /**
     * 执行失败回调方法
     * @param sourceState
     * @param event
     * @param context
     */
    void onFail(S sourceState, E event, C context);
}
