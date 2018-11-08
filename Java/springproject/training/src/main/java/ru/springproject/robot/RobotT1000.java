package ru.springproject.robot;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.springproject.ColorStyle;
import ru.springproject.interfaces.Hand;
import ru.springproject.interfaces.Head;
import ru.springproject.interfaces.Leg;
import ru.springproject.interfaces.Robot;

@Component
public class RobotT1000 extends BaseRobot implements Robot , InitializingBean, DisposableBean {

    private ColorStyle color;
    private int year;
    private boolean soundIsEnabled;

    public int getYear() {
        return year;
    }
    public boolean isSoundIsEnabled() {
        return soundIsEnabled;
    }
    public ColorStyle getColor() {
        return color;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public void setSoundIsEnabled(boolean soundIsEnabled) {
        this.soundIsEnabled = soundIsEnabled;
    }
    public void setColor(ColorStyle color) {
        this.color = color;
    }

    public RobotT1000() { }

//    public RobotT1000(Head head, Hand hand, Leg leg) {
//        //super(head, hand, leg);
//        System.out.println("RobotT1000");
//    }

    @Bean
    @Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RobotT1000 robotT1000_id_1(){
        return new RobotT1000();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RobotT1000 robotT1000_id_2(){
        return new RobotT1000(ColorStyle.BLACK, 1998, true);
    }

    public RobotT1000(ColorStyle color, int year, boolean soundIsEnabled) {
        this.color = color;
        this.year = year;
        this.soundIsEnabled = soundIsEnabled;
        System.out.println("RobotT1000");
    }

    public RobotT1000(Head head, Hand hand, Leg leg, ColorStyle color, int year, boolean soundIsEnabled) {
        //super(head, hand, leg);

        this.color = color;
        this.year = year;
        this.soundIsEnabled = soundIsEnabled;
        System.out.println("RobotT1000");
    }

    @Override
    public void dance() {
        System.out.println("RobotT1000 is dancing");
    }

    @Override
    public void doByObjects() {
        getHead().think();
        getHand().take();
        getLeg().go();

        System.out.println("color: " + color);
        System.out.println("year: " + year);
        System.out.println("can you play sound? " + soundIsEnabled);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
       // System.out.println("RobotT1000 - afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
       // System.out.println("destroy");
    }
}
