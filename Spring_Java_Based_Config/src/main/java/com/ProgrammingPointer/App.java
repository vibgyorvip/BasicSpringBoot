package com.ProgrammingPointer;

import com.ProgrammingPointer.Config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Alien obj = context.getBean(Alien.class);
        System.out.println(obj.getAge());
        obj.code();

        //Desktop dt = context.getBean("com2",Desktop.class);
//        Desktop dt = context.getBean(Desktop.class);
//        dt.compile();
//
//        Desktop dt1 = context.getBean(Desktop.class);
//        dt1.compile();








//        //creating the container and spring.xml have config. of container
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//
//        Alien obj = context.getBean("alien", Alien.class);
//        //obj.setAge(10);
//        //set the age by using setter injection in spring.xml
//        System.out.println(obj.getAge());
//        obj.code();
//
//        Desktop obj1=(Desktop) context.getBean(Desktop.class);



    }
}
