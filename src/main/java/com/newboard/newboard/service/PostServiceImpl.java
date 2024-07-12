package com.newboard.newboard.service;

import com.newboard.newboard.domain.Post;
import com.newboard.newboard.domain.User;
import com.newboard.newboard.dto.ListDTO;
import com.newboard.newboard.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Page<ListDTO> getAllPosts(Pageable pageable) {
        //List<Post> posts = postRepository.findAll();
        Page<Post> posts = postRepository.findAll(pageable);

        return posts.map(post -> ListDTO.builder()
                .postid(post.getPostid())
                .title(post.getTitle())
                .nickname(post.getUser().getNickname())
                .entry_date(post.getEntry_date())
                .build());

    }
}
