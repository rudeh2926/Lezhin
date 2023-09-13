package com.example.lezhin.domain.user.presentation.dto;

import com.example.lezhin.domain.user.enums.Gender;
import com.example.lezhin.domain.user.enums.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSignupRequest {

    private String userEmail;
    private String userName;
    private String password;
    private Type type;
    private Gender gender;
}
