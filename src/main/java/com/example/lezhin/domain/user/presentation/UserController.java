package com.example.lezhin.domain.user.presentation;

import com.example.lezhin.domain.user.presentation.request.UserLoginRequest;
import com.example.lezhin.domain.user.presentation.request.UserSignupRequest;
import com.example.lezhin.domain.user.presentation.response.UserResponse;
import com.example.lezhin.domain.user.service.*;
import com.example.lezhin.global.security.jwt.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONTokener;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserSignupService userSignupService;
    private final UserDeleteService userDeleteService;
    private final FindUserWithAdultWebToonService findUserWithAdultWebToonService;
    private final UserLoginService userLoginService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void signup(@RequestBody UserSignupRequest userSignupRequest) {
        userSignupService.signup(userSignupRequest);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody UserLoginRequest userLoginRequest) {
        return userLoginService.login(userLoginRequest);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody String password) {userDeleteService.deleteUser(password);
    }


    @GetMapping
    public List<UserResponse> findUserWithAdultWebToon() {
        return findUserWithAdultWebToonService.findUserWithAdultWebToon();
    }
}
