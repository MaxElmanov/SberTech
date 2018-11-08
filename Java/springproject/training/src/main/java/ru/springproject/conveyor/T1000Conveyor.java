package ru.springproject.conveyor;

import ru.springproject.interfaces.Robot;
import ru.springproject.interfaces.RobotConveyor;

public abstract class T1000Conveyor implements RobotConveyor {
    @Override
    public abstract Robot createRobot();
}
