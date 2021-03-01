package sej.springexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "sej.springexample.service", basePackageClasses = HelloService.class)
public class UseCustomStarterApp {
    public static void main(String arg[]) {
        SpringApplication.run(UseCustomStarterApp.class, arg).getBean(HelloService.class).hi();
    }
}
