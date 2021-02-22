package sej.springexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import sej.springexample.model.UserEntity;
import sej.springexample.model.UserRole;
import sej.springexample.repository.UserRepository;

@SpringBootApplication
public class JPAMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JPAMain.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        userRepository.save(new UserEntity("조상은", 24, UserRole.ADMIN)); //db에 저장. insert 와 같은 기능
        UserEntity user = userRepository.findByUserName("조상은"); //이름 찾기. 무조건 findBy[객체 이름] 으로 해야함
        System.out.println("나이: " + user.getAge() + ", 이름: " + user.getUserName() + ", 생성일: " + user.getCreateAt());
    }
}
