package com.programmingpointer.myFirstProject.repo;

import com.programmingpointer.myFirstProject.Model.Laptop;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRespository {
    public void save(Laptop lap)
    {
        System.out.println("Saved in Database");
    }
}
