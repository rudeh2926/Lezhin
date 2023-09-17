package com.example.lezhin.domain.user.presentation.response;

import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.user.enums.Gender;
import com.example.lezhin.domain.user.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponse {

    private String userName;
    private Gender gender;

    public UserResponse(User user) {
        this.userName = user.getUserName();
        this.gender = user.getGender();
    }
}
