package todo;

import 
  org.springframework.context.support.ClassPathXmlApplicationContext;


public class Launcher {
    public void launch() {
        String[] contextPaths = new String[] {};
        new ClassPathXmlApplicationContext(contextPaths);
    }
}