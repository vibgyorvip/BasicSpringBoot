package com.ProgrammingPointer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;

@Component
public class Alien {

    @Value("21")
    private int age;

   // @Autowired
    //@Qualifier("laptop")
    private Computer com;

    public Alien()
    {
        System.out.println("Alien Class Object Created !!");
    }

//    public Alien(int age)
//    {
//        System.out.println("Para Constructor Called");
//        this.age=age;
//    }

//   @ConstructorProperties({"age","lap"})
//   public Alien(int age, Laptop lap) {
//        this.age = age;
//        this.lap = lap;
//    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
       // System.out.println("Using Setter Method to set Age");
        this.age = age;
    }

    public Computer getCom() {
        return com;
    }

    @Autowired
   //@Qualifier("laptop")
    public void setCom(Computer com) {
        this.com = com;
    }

    public void code()
    {
        System.out.println("Coding...");
        com.compile();
    }
}
