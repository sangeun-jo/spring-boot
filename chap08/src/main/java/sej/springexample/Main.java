package sej.springexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import sej.springexample.model.UserVO;
import sej.springexample.repository.UserRepository;

@SpringBootApplication
public class Main{
    public static void main(String[] arg){
        SpringApplication.run(Main.class, arg);
    }
}
