package com.ProgrammingPointer;

import java.beans.ConstructorProperties;

public class Alien {

    private int age;
    private Laptop lap;

    public Alien()
    {
        System.out.println("Alien Class Object Created !!");
    }

//    public Alien(int age)
//    {
//        System.out.println("Para Constructor Called");
//        this.age=age;
//    }

   @ConstructorProperties({"age","lap"})
   public Alien(int age, Laptop lap) {
        this.age = age;
        this.lap = lap;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Using Setter Method to set Age");
        this.age = age;
    }

    public Laptop getLap() {
        return lap;
    }

    public void setLap(Laptop lap) {
        this.lap = lap;
    }

    public void code()
    {
        System.out.println("Coding...");
        lap.compile();
    }
}
