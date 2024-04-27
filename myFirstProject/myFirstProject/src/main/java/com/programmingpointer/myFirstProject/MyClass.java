package com.programmingpointer.myFirstProject;
// To create API endpoint


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyClass {

    @GetMapping("abc")
    public String sayHello()
    {
        return "welcome Programming Pointer !!";
    }
}
