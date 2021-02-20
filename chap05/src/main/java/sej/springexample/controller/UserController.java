package sej.springexample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sej.springexample.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class UserController {
    private static List<User> userList = new ArrayList<User>();
    {
        userList.add(new User(1, "sej01", "user01@test.com", "python", new Date()));
        userList.add(new User(2, "sej02", "user02@test.com", "java", new Date()));
        userList.add(new User(3, "sej03", "user03@test.com", "spring", new Date()));
        userList.add(new User(4, "sej04", "user04@test.com", "django", new Date()));
    }

    @RequestMapping("/user/{userNo}")
    public ResponseEntity<User> getUserInfo(@PathVariable int userNo){
        User user = userList.get(userNo);
        return new ResponseEntity(user, OK);
    }

    @RequestMapping("/user")
    public ResponseEntity<List<User>> getUserList() {
        HashMap<String, Object> resultList = new HashMap<>();
        resultList.put("result", userList);
        return new ResponseEntity(resultList, OK);
    }
}
