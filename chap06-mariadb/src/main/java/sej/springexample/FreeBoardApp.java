package sej.springexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import sej.springexample.model.FreeBoardVO;
import sej.springexample.repository.FreeBoardRepository;

@SpringBootApplication(exclude = WebMvcAutoConfiguration.class)
public class FreeBoardApp implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(FreeBoardApp.class, args);
    }

    @Autowired
    FreeBoardRepository freeBoardRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("freeboard run");
        FreeBoardVO freeBoardVO = new FreeBoardVO();
        freeBoardVO.setUserName("hong");
        freeBoardVO.setCategory("101");
        freeBoardVO.setContent("freeboard first article");
        freeBoardVO.setTitle("hello");

        freeBoardRepository.registBoard(freeBoardVO);
    }
}
