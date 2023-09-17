package com.example.lezhin.domain.user.service;

import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.user.domain.repository.UserRepositoryImp;
import com.example.lezhin.domain.user.facade.UserFacade;
import com.example.lezhin.domain.user.presentation.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindUserWithAdultWebToonService {

    private final UserFacade userFacade;
    private final UserRepositoryImp userRepositoryImp;

    @Transactional(readOnly = true)
    public List<UserResponse> findUserWithAdultWebToon() {
        User user = userFacade.getCurrentUser();


        List<User> findUser = userRepositoryImp.findUsersWithDistinctAdultWebtoonViews();
        List<UserResponse> findUsers = findUser.stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());

        return findUsers;
    }
}
