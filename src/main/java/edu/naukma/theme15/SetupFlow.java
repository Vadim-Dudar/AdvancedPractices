package edu.naukma.theme15;

import java.util.ArrayList;
import java.util.List;

public class SetupFlow {
    private final List<String> executed = new ArrayList<>();

    @Step(order = 2)
    private void task_2() {
        executed.add("task 2");
    }

    @Step(order = 4)
    void task_1() {
        executed.add("task 1");
    }

    @Step(order = 3)
    public void task_3() {
        executed.add("task 3");
    }

    public List<String> executed() {
        return executed;
    }
}
