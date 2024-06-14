package com.programmingpointer.myFirstProject.service;


import com.programmingpointer.myFirstProject.Model.Laptop;
import com.programmingpointer.myFirstProject.repo.LaptopRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {
    @Autowired
    private LaptopRespository repo;
    public void addLaptop(Laptop lap)
    {
        repo.save(lap);
    }
    public boolean isGoodForProg(Laptop lap)
    {
        return true;
    }
}
