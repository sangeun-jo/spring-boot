package sej.springexample.prop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties({MyProperties.class})
public class PropApp {
    public static void main(String arg[]) {
        SpringApplication.run(PropApp.class, arg);
    }

    @Autowired
    MyProperties prop;

    @Bean
    CommandLineRunner values() {
        return  arg -> {
            System.out.println("server ip: " + prop.getServerIp());
            System.out.println("app name: " + prop.getName());
        };
    }
}
