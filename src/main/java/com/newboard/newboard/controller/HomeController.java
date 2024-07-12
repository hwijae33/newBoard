package com.newboard.newboard.controller;


import com.newboard.newboard.dto.ListDTO;
import com.newboard.newboard.service.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final PostServiceImpl postService;

    @GetMapping("/")
    public String index(Model model,@PageableDefault(page = 0, size = 10,  direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ListDTO> posts = postService.getAllPosts(pageable);
        model.addAttribute("posts", posts.getContent());
        model.addAttribute("currentPage", posts.getNumber());
        model.addAttribute("totalPages", posts.getTotalPages());
        return "index";
    }

}
