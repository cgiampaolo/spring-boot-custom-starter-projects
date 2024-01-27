package it.home.starter.customstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
//@EnableCaching
@ConfigurationPropertiesScan("it.home.starter.customstarter.properties")
public class CustomStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomStarterApplication.class,args);
    }


}
