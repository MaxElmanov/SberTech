package ru.springproject.pool;

import ru.springproject.interfaces.Robot;
import ru.springproject.interfaces.RobotPool;
import ru.springproject.robot.RobotT1000;

import java.util.Collection;

public class T1000Pool implements RobotPool {

    private Collection<Robot> robotCollection;

    public T1000Pool(Collection<Robot> robotCollection) {
        this.robotCollection = robotCollection;
    }

    @Override
    public Collection<Robot> getRobotCollection() {
        return robotCollection;
    }
    public void setRobotCollection(Collection<Robot> robotCollection) {
        this.robotCollection = robotCollection;
    }

    public void beginShow() {
        for(Robot robot : robotCollection){
            robot.doByObjects();
        }
    }

}
