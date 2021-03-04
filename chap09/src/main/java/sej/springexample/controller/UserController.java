package sej.springexample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sej.springexample.model.UserVO;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/list")
    public ResponseEntity<?> findUserInfoAll() throws Exception{
        return null;
    }

    @RequestMapping("/regist")
    public ResponseEntity<?> registUser(@RequestBody UserVO userVO){
        return null;
    }

    @RequestMapping("/search")
    public ResponseEntity<?> findUserListbyNames(@RequestParam("username") String userName){
        return null;
    }

    @RequestMapping("/{username}")
    public ResponseEntity<?> findByUserOne(@PathVariable("username") String userName){
        return null;
    }

    @RequestMapping("/exception")
    public ResponseEntity<?> exceptionUser()throws Exception{
        throw new Exception("exception occur");
    }
}
