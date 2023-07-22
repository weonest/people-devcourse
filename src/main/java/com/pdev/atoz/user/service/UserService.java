package com.pdev.atoz.user.service;

import com.pdev.atoz.user.domain.User;
import com.pdev.atoz.user.dto.UserJoinRequest;
import com.pdev.atoz.user.dto.UserLoginRequest;

public interface UserService {
    void userJoin(UserJoinRequest request);

    User login(UserLoginRequest request);

    User getLoginUserById(Long userId);

    User getLoginUserByRole(String role);
}
