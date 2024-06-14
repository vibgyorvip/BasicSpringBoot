package com.ProgrammingPointer.Config;

import com.ProgrammingPointer.Alien;
import com.ProgrammingPointer.Computer;
import com.ProgrammingPointer.Desktop;
import com.ProgrammingPointer.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.ProgrammingPointer")
public class AppConfig {
/*
    @Bean
    public Alien alien( @Autowired Computer com) //@Qualifier("laptop")
    {
        Alien obj = new Alien();
        obj.setAge(25);
        //obj.setCom(desktop());
        obj.setCom(com);
        return obj;
    }


    //@Bean(name="com2")
    //@Bean(name={"com2","desktop","Beast"})
    @Bean
   //@Scope("prototype")
    public Desktop desktop()
    {
        return new Desktop();
    }

    @Bean
    @Primary
    public Laptop laptop()
    {
        return new Laptop();
    }

 */
}
