package org.chench.component.statemachine.impl;

/**
 * TODO
 *
 * @Author: quwb
 * @CreateTime: 2023-03-16  09:03
 * @Version: 1.0
 */
public class Debuger {

    private static boolean isDebugOn = false;

    public static void debug(String message) {
        if (isDebugOn) {
            System.out.println(message);
        }
    }

    public static void enableDebug() {
        isDebugOn = true;
    }

}
