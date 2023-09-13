package com.example.lezhin.domain.user.domain;

import com.example.lezhin.domain.user.enums.Gender;
import com.example.lezhin.domain.user.enums.Type;
import com.example.lezhin.global.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User extends BaseEntity {

    private String userEmail;

    private String userName;

    private String password;

    private LocalDateTime localDateTime;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Type type;


}
