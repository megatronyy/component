package org.chench.component.statemachine;

public interface Condition<C> {

    /**
     * @param context context object
     * @return whether the context satisfied current condition
     */
    boolean isStatisfied(C context);

    default String name() {
        return this.getClass().getSimpleName();
    }
}
