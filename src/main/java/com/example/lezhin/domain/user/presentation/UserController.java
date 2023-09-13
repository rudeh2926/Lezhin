package com.example.lezhin.domain.user.presentation;

import com.example.lezhin.domain.user.presentation.dto.UserSignupRequest;
import com.example.lezhin.domain.user.service.UserSignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserSignupService userSignupService;

    public void signup(UserSignupRequest userSignupRequest) {
        userSignupService.signup(userSignupRequest);
    }
}
