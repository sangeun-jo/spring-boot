package serviceTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sej.springexample.model.UserVO;
import sej.springexample.service.UserService;

public class UserServiceTest extends ServiceTestConfig {
    @Autowired
    UserService userService;

    @Test
    public void findUserList() {
        userService.findAllUserInfo();
    }

    @Test
    public void findUserNameTest() {
        String uname = "kim1";
        UserVO user = userService.findByOneUserName(uname);
        System.out.println("name: " + user.getUserName());
        System.out.println("id: " + user.getId());
        System.out.println("email: " + user.getEmail());
    }
}
