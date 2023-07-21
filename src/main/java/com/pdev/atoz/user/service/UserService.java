package com.pdev.atoz.user.service;

import com.pdev.atoz.user.domain.User;
import com.pdev.atoz.user.dto.UserJoinRequest;
import com.pdev.atoz.user.dto.UserLoginRequest;
import com.pdev.atoz.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class UserService {

    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void userJoin(UserJoinRequest request) {
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
        Optional<User> user = userRepository.findByLoginId(request.getLoginId());

        if (user.isPresent()) {
            if (user.get().getPassword().equals(request.getPassword())) {
                return user.get();
            }
        }
        return null;
    }

    public User getLoginUserById(Long userId) {
        if (userId == null) return null;

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) return null;

        return user.get();
    }
}
