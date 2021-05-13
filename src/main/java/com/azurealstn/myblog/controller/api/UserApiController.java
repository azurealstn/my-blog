package com.azurealstn.myblog.controller.api;

import com.azurealstn.myblog.dto.ResponseDto;
import com.azurealstn.myblog.model.RoleType;
import com.azurealstn.myblog.model.User;
import com.azurealstn.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession httpSession;

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user) {
        System.out.println("UserApiController: save 호출");
        user.setRole(RoleType.USER);
        userService.userJoin(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PostMapping("/api/user/login")
    public ResponseDto<Integer> login(@RequestBody User user) {
        System.out.println("UserApiController: login 호출");
        User principal = userService.userLogin(user); //principal: 접근주체

        if (principal != null) {
            httpSession.setAttribute("principal", principal);
        }
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
