package com.example.lezhin.domain.user.service;

import com.example.lezhin.domain.user.exception.UserNameOrEmailAlreadyExistException;
import com.example.lezhin.domain.user.presentation.dto.UserSignupRequest;
import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserSignupService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signup(UserSignupRequest userSignupRequest) {

        if (userRepository.existsByUserEmail(userSignupRequest.getUserEmail()) || userRepository.existsByUserName(userSignupRequest.getUserName())) {
            throw UserNameOrEmailAlreadyExistException.EXCEPTION;
        }

        LocalDateTime registerDate = LocalDateTime.now();

        userRepository.save(
                User.builder()
                        .userEmail(userSignupRequest.getUserEmail())
                        .userName(userSignupRequest.getUserName())
                        .password(passwordEncoder.encode(userSignupRequest.getPassword()))
                        .gender(userSignupRequest.getGender())
                        .type(userSignupRequest.getType())
                        .localDateTime(registerDate)
                        .build());
    }
}
