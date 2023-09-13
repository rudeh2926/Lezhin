package com.example.lezhin.domain.user.facade;

import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.user.domain.repository.UserRepository;
import com.example.lezhin.domain.user.exception.UserEmailNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByEmail(email);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByUserEmail(email)
                .orElseThrow(() -> UserEmailNotFoundException.EXCEPTION);
    }
}
