package todo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import todo.ui.MainFrame;

public class ToDo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        MainFrame mf = (MainFrame)context.getBean("myFrame_1");
    }
}