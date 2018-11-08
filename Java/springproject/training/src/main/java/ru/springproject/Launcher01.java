package ru.springproject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.springproject.conveyor.T1000Conveyor;
import ru.springproject.interfaces.Robot;
import ru.springproject.pool.T1000Pool;
import ru.springproject.robot.RobotT1000;

public class Launcher01 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/all-context.xml");
        RobotT1000 t1000 = (RobotT1000)context.getBean("robotT1000_id_1");
        t1000.doByObjects();
        RobotT1000 t1000_2 = (RobotT1000)context.getBean("robotT1000_id_2");
        t1000_2.doByObjects();
    }
}
