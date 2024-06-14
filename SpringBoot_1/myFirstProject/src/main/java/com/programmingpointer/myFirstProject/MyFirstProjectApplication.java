package com.programmingpointer.myFirstProject;

import com.programmingpointer.myFirstProject.Model.Alien;
import com.programmingpointer.myFirstProject.Model.Laptop;
import com.programmingpointer.myFirstProject.service.LaptopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyFirstProjectApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(MyFirstProjectApplication.class, args);

		LaptopService service= context.getBean(LaptopService.class);

		Laptop lap = context.getBean(Laptop.class);
		service.addLaptop(lap);





//		Alien obj =context.getBean(Alien.class);
//		obj.code();
	}

}
