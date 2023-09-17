package com.example.lezhin.domain.user.presentation;

import com.example.lezhin.domain.user.presentation.request.UserSignupRequest;
import com.example.lezhin.domain.user.service.UserDeleteService;
import com.example.lezhin.domain.user.service.UserSignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserSignupService userSignupService;
    private final UserDeleteService userDeleteService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void signup(UserSignupRequest userSignupRequest) {
        userSignupService.signup(userSignupRequest);
    }

    @DeleteMapping
    public void deleteUser(String password) {
        userDeleteService.deleteUser(password);
    }
}
