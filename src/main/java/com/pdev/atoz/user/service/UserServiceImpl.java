package com.pdev.atoz.user.service;

import com.pdev.atoz.global.exception.DuplicateValueException;
import com.pdev.atoz.user.domain.User;
import com.pdev.atoz.user.dto.UserJoinRequest;
import com.pdev.atoz.user.dto.UserLoginRequest;
import com.pdev.atoz.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Transactional
@Service
public class UserServiceImpl implements UserService{

    public final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void userJoin(UserJoinRequest request) {
        validateRequest(request);
        User user = User.builder()
                .loginId(request.getLoginId())
                .password(request.getPassword())
                .nickname(request.getNickname())
                .email(request.getEmail())
                .role(request.getRole())
                .build();
        userRepository.save(user);
    }

    public User login(UserLoginRequest request) {
        User user = userRepository.findByLoginId(request.getLoginId())
                .orElseThrow(NoSuchElementException::new);
        if (user.getPassword().equals(request.getPassword())) return user;
        throw new IllegalArgumentException();
    }

    public User getLoginUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(NoSuchElementException::new);
        return user;
    }

    public User getLoginUserByRole(String role) {
        User user = userRepository.findByRole(role)
                .orElseThrow(NoSuchElementException::new);
        return user;
    }

    private void checkLoginIdDuplicate(String loginId) {
        if (userRepository.existsByLoginId(loginId))
            throw new DuplicateValueException("loginId");
    }

    private void checkEmailDuplicate(String email) {
        if (userRepository.existsByEmailMailAddress(email)) {
            throw new DuplicateValueException("email");
        }
    }

    private void checkNicknameDuplicate(String nickname) {
        if (userRepository.existsByNickname(nickname)) {
            throw new DuplicateValueException("nickname");
        }
    }

    private void validateRequest(UserJoinRequest request) {
        checkLoginIdDuplicate(request.getLoginId());
        checkNicknameDuplicate(request.getNickname());
        checkEmailDuplicate(request.getEmail());
    }
}
