import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import sej.springexample.RestApp;
import sej.springexample.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestApp.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RestAPITest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetUserById(){
        String url = "http://localhost:9090/user/0";
        User user = restTemplate.getForObject(url, User.class);
        System.out.println("등록일: " + user.getRegDate() + "," + user.getUserId() + "," + user.getUname());
    }

    @Test //웹의 제이슨 응답을 맵으로 파싱
    public void testGetUsers() {
        String url = "http://localhost:9090/user";
        ResponseEntity<Map<String, List<User>>> result = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<Map<String, List<User>>>() {});
        Map<String, List<User>> tempMap = (Map) result.getBody();
        ArrayList<User> resultArr = (ArrayList<User>) tempMap.get("result");
        for (User usr:resultArr) {
            System.out.println(usr.getUname());
        }
    }
}
