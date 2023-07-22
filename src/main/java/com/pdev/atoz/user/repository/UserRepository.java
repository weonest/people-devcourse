package com.pdev.atoz.user.repository;

import com.pdev.atoz.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLoginId(String loginId);

    Optional<User> findByEmailMailAddress(String email);

    Optional<User> findByNickname(String nickname);

    Optional<User> findByRole(String role);

    boolean existsByLoginId(String loginId);

    boolean existsByNickname(String nickname);

    boolean existsByEmailMailAddress(String email);
}
