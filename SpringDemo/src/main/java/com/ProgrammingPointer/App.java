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

        Alien obj1 = (Alien) context.getBean("alien");
        //obj1.code();
        obj1.age=10;
        System.out.println(obj1.age);

        Alien obj2 = (Alien) context.getBean("alien");
       // obj2.code();
        System.out.println(obj2.age);


    }
}
