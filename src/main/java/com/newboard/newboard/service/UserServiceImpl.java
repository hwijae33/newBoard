package com.newboard.newboard.service;

import com.newboard.newboard.domain.User;
import com.newboard.newboard.dto.SignUpFormDTO;
import com.newboard.newboard.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        return user
                .orElseThrow(() -> new UsernameNotFoundException((username)));
    }

    @Transactional
    public Long save(SignUpFormDTO sign) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(sign.getPassword());

        User user = User.builder()
                .username(sign.getUsername())
                .password(encodedPassword)
                .nickname(sign.getNickname())
                .build();

        return userRepository.save(user).getUserid(); // 또는 다른 필요한 ID 값을 반환할 수 있습니다.
    }

}
