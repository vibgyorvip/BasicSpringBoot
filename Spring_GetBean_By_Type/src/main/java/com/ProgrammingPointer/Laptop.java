package com.ProgrammingPointer;

public class Laptop implements Computer {
    public Laptop()
    {
        System.out.println("Laptop Class Object Created !!");
    }

    @Override
    public void compile()
    {
        System.out.println("Compiling using Laptop");
    }
}
