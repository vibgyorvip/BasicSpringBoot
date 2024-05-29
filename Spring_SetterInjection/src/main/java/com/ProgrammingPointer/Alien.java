package com.ProgrammingPointer;

public class Alien {

    int age;
    public Alien()
    {
        System.out.println("Alien Class Object Created !!");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Using Setter Method to set Age");
        this.age = age;
    }

    public void code()
    {
        System.out.println("Coding...");
    }
}
