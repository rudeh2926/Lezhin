package com.example.lezhin.domain.user.domain;

import com.example.lezhin.domain.disLike.domain.DisLike;
import com.example.lezhin.domain.like.domain.Like;
import com.example.lezhin.domain.user.enums.Gender;
import com.example.lezhin.domain.user.enums.Type;
import com.example.lezhin.domain.visit.domain.Visit;
import com.example.lezhin.domain.webToon.domain.WebToon;
import com.example.lezhin.global.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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


    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<WebToon> webToon = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Like> like = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<DisLike> disLike = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Visit> visit = new ArrayList<>();
}
