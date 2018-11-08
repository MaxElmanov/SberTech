package ru.springproject.robot;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import ru.springproject.interfaces.Hand;
import ru.springproject.interfaces.Head;
import ru.springproject.interfaces.Leg;

public abstract class BaseRobot implements InitializingBean {
    @Autowired
    private Head head;
    @Autowired
    private Hand hand;
    @Autowired
    private Leg leg;

    public BaseRobot() {
        System.out.println("BaseModel");
    }

//    public BaseRobot(Head head, Hand hand, Leg leg) {
//        this.head = head;
//        this.hand = hand;
//        this.leg = leg;
//        System.out.println("BaseModel");
//    }


    public Hand getHand() {
        return hand;
    }
    public Head getHead() {
        return head;
    }
    public Leg getLeg() {
        return leg;
    }

    @Required
    public void setHand(Hand hand) {
        this.hand = hand;
    }
    @Required
    public void setHead(Head head) {
        this.head = head;
    }
    @Required
    public void setLeg(Leg leg) {
        this.leg = leg;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BaseRobot - afterPropertiesSet");
    }
}
