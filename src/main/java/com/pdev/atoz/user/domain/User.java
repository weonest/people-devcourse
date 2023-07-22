package com.pdev.atoz.user.domain;

import com.pdev.atoz.order.domain.Email;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loginId;

    private String password;

    private String nickname;

    private Email email;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Builder
    public User(String loginId,
                String password,
                String nickname,
                String email,
                UserRole role) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.email = new Email(email);
        this.role = role;
    }
}
