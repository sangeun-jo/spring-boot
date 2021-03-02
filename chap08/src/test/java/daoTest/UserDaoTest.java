package daoTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sej.springexample.model.UserVO;
import sej.springexample.repository.UserRepository;

public class UserDaoTest extends MybatisTestConfig {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testList() {
        System.out.println(userRepository.getUserInfoAll());
    }

    @Test
    public void createUser() {
        UserVO userVO = new UserVO();
        userVO.setId("sej115");
        userVO.setUserName("조상은");
        userVO.setEmail("test1@sej.com");
        userRepository.adduserInfo(userVO);
        System.out.println(userRepository.getUserInfoAll());
    }
}
