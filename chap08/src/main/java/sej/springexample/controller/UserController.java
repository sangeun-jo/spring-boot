package sej.springexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sej.springexample.exception.UserNotFoundException;
import sej.springexample.model.UserVO;
import sej.springexample.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/list")
    public ResponseEntity<?> findUserInfoAll() throws Exception {
        return new ResponseEntity(userService.findAllUserInfo(), HttpStatus.OK);
    }

    @RequestMapping(value = "/regist", method = RequestMethod.POST) // /user/regist url로 접속 시, json 형태로 userVO 전달받음
    public ResponseEntity<?> registUser(@Validated @RequestBody UserVO userVO) {
        System.out.println("controller vo check::" + userVO.toString());
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @RequestMapping("/search")
    public ResponseEntity<?> findUserListByNames(@RequestParam("username") String userName) {
        return new ResponseEntity(userService.findByLikeUserName(userName), HttpStatus.OK);
    }

    @RequestMapping("/{username}")
    public ResponseEntity<?> findByUserOne(@PathVariable("username") String userName) {
        UserVO user = userService.findByOneUserName(userName);
        if (user == null) {
            throw new UserNotFoundException("user not found");
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }


}
