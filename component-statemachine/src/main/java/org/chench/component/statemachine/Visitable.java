package org.chench.component.statemachine;

/**
 * Visitable
 *
 * @author quwb
 * @date 2023-03-13
 */
public interface Visitable {
    String accept(final Visitor visitor);
}
