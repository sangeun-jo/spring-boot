package sej.springexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import sej.springexample.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication(exclude = WebMvcAutoConfiguration.class)
public class ForEachMain implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ForEachMain.class, args);
    }

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception{
        List<String> userList = new ArrayList<>();
        userList.add("test1");
        userList.add("test2");
        userList.add("test3");

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("user_list", userList);

        System.out.println(userRepository.findByForeach(paramMap));
    }
}
