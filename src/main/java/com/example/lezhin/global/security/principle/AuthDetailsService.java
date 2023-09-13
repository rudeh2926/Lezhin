package com.example.lezhin.global.security.principle;

import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.user.domain.repository.UserRepository;
import com.example.lezhin.domain.user.exception.UserEmailNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findByUserEmail(email)
                .orElseThrow(() -> UserEmailNotFoundException.EXCEPTION);
        return new AuthDetails(user);
    }
}