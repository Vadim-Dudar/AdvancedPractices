package edu.naukma.theme15;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class StepRunner {
    public static void run(Object target) {
        Method[] steps = Arrays.stream(target.getClass().getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Step.class))
                .sorted(Comparator.comparingInt(method -> method.getAnnotation(Step.class).order()))
                .toArray(Method[]::new);

        for (Method step : steps) {
            try {
                step.trySetAccessible();
                step.invoke(target);
            } catch (InvocationTargetException e) {
                Throwable cause = e.getCause() == null ? e : e.getCause();
                throw new StepRunnerException("Step failed: " + step.getName(), cause);
            } catch (IllegalAccessException e) {
                throw new StepRunnerException("Cannot access step: " + step.getName(), e);
            }
        }
    }
}
