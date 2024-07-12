package com.newboard.newboard.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpFormDTO {
    private String username;
    private String password;
    private String nickname;

}

