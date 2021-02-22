package sej.springexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import sej.springexample.service.SchoolService;

@SpringBootApplication
public class ManyToOneRun {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ManyToOneRun.class);
        SchoolService schoolService = context.getBean(SchoolService.class);
        schoolService.findStudentInfo();
    }
}
