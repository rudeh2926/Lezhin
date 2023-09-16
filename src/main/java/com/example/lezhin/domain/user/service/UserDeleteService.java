package com.example.lezhin.domain.user.service;

import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.user.domain.repository.UserRepository;
import com.example.lezhin.domain.user.exception.PasswordMissMatch;
import com.example.lezhin.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDeleteService {

    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;

    public void deleteUser(String password) {

        User user = userFacade.getCurrentUser();

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw PasswordMissMatch.EXCEPTION;
        }

        userFacade.deleteUser(user);
    }
}
