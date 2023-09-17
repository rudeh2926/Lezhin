package com.example.lezhin.domain.user.service;

import com.example.lezhin.domain.user.exception.UserEmailNotFoundException;
import com.example.lezhin.domain.user.presentation.request.UserLoginRequest;
import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.user.domain.repository.UserRepository;
import com.example.lezhin.domain.user.exception.PasswordMissMatch;
import com.example.lezhin.global.security.jwt.JwtProvider;
import com.example.lezhin.global.security.jwt.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoginService {

    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public TokenResponse login(UserLoginRequest userLoginRequest) {

        User user = userRepository.findByUserEmail(userLoginRequest.getUserEmail())
                .orElseThrow(()-> UserEmailNotFoundException.EXCEPTION);

        if (passwordEncoder.matches(userLoginRequest.getPassword(), user.getPassword())) {
            throw PasswordMissMatch.EXCEPTION;
        }

        return jwtProvider.getToken(user);
    }
}
