package com.newboard.newboard.controller;

import com.newboard.newboard.dto.SignUpFormDTO;
import com.newboard.newboard.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@AllArgsConstructor
public class UserController {

    private final UserServiceImpl USERSERVICE;

    // index.html의 method를 get타입으로 받아서 /loginForm 매핑해준다.
    @GetMapping("/loginForm")
    public String loginForm(){
        // url 주소가 맞으면 /user/loginForm.html를 띄어 준다.
        return "/user/loginForm";
    }
    @GetMapping("/register")
    public String register(){
        // url 주소가 맞으면 /user/loginForm.html를 띄어 준다.
        return "/user/register";
    }

    @PostMapping("/register")
    public String auth(SignUpFormDTO sign){
        USERSERVICE.save(sign);
        return "redirect:/user/loginForm";
    }
}