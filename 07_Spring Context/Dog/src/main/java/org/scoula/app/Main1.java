package org.scoula.app;

import org.scoula.config.ProjectConfig;
import org.scoula.domain.Dog;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main1 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Dog d = context.getBean("꼬미",Dog.class);
        Dog d1 = context.getBean("밤비",Dog.class);
        Dog d2 = context.getBean("해피",Dog.class);
        System.out.println("[1] 등록된 강아지 목록:");
        System.out.println(d);
        System.out.println(d1);
        System.out.println(d2);

    }
}