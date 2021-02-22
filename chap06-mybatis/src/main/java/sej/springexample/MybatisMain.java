package sej.springexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import sej.springexample.model.UserVO;
import sej.springexample.repository.UserRepository;

@SpringBootApplication(exclude = WebMvcAutoConfiguration.class)
public class MybatisMain implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(MybatisMain.class, args);
    }

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception{
        System.out.println(userRepository.getUserInfoAll().toString());

        UserVO userEntity = new UserVO("test4", "jse", "1234");
        userRepository.adduserInfo(userEntity);

        System.out.println("===after inserting===");
        System.out.println(userRepository.getUserInfoAll().toString());

        System.out.println("===like name searching===");
        System.out.println(userRepository.findByUserNameLike("ki").toString());

        System.out.println("===searching just one name===");
        UserVO userVO = userRepository.findByUserName("jse");
        System.out.println(userVO.getId() + "," + userVO.getPassWord() + "," + userVO.getUserName());
    }


}
