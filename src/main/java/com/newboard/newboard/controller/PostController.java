package com.newboard.newboard.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@Log4j2
public class PostController {

    @GetMapping("/write")
    public String write(){
        return "post/write";
    }

    @GetMapping("/update")
    public String update(){
        return "post/update";
    }
}
