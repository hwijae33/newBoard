package com.newboard.newboard.service;

import com.newboard.newboard.dto.ListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface PostService {
    Page<ListDTO> getAllPosts(Pageable pageable);
}
