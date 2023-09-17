package com.example.lezhin.domain.user.domain.repository;

import com.example.lezhin.domain.user.domain.User;

import java.util.List;

public interface UserRepositoryCustom {
    List<User>  findUsersWithDistinctAdultWebtoonViews();
}
