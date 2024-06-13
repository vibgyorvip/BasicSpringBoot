package com.ProgrammingPointer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //creating the container and spring.xml have config. of container
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Alien obj = context.getBean("alien", Alien.class);
        //obj.setAge(10);
        //set the age by using setter injection in spring.xml
        System.out.println(obj.getAge());
        obj.code();

        Desktop obj1=(Desktop) context.getBean(Desktop.class);



    }
}
