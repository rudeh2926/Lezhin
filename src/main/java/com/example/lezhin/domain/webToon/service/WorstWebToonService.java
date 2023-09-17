package com.example.lezhin.domain.webToon.service;

import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.user.facade.UserFacade;
import com.example.lezhin.domain.webToon.domain.WebToon;
import com.example.lezhin.domain.webToon.domain.repository.WebToonRepositoryImp;
import com.example.lezhin.domain.webToon.presentation.dto.response.WebToonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorstWebToonService {

    private final UserFacade userFacade;
    private final WebToonRepositoryImp webToonRepositoryImp;

    @Transactional(readOnly = true)
    public List<WebToonResponse> findWorstWebToon() {

        User user = userFacade.getCurrentUser();

        List<WebToon> findWorstWebToon = webToonRepositoryImp.findMostDisLikedWebtoons();
        List<WebToonResponse> findWorstWebToons = findWorstWebToon
                .stream()
                .map(WebToonResponse::new)
                .collect(Collectors.toList());

        return findWorstWebToons;
    }
}
