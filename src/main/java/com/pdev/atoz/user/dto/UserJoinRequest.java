package com.pdev.atoz.user.dto;

import com.pdev.atoz.user.domain.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserJoinRequest {

    @NotBlank(message = "아이디를 입력해 주세요")
    private final String loginId;

    @NotBlank(message = "비밀번호를 입력해 주세요.")
    private final String password;

    private final String passwordCheck;

    @NotBlank(message = "닉네임을 입력해 주세요")
    private final String nickname;

    @NotBlank(message = "이메일을 입력해 주세요")
    private final String email;

    @NotNull
    private final UserRole role;

}
