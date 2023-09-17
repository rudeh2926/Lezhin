package com.example.lezhin.domain.webToon.service;

import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.user.facade.UserFacade;
import com.example.lezhin.domain.webToon.domain.WebToon;
import com.example.lezhin.domain.webToon.domain.repository.WebToonRepositoryImp;
import com.example.lezhin.domain.webToon.presentation.dto.response.WebToonListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BestWebToonService {

    private final UserFacade userFacade;
    private final WebToonRepositoryImp webToonRepositoryImp;

    @Transactional(readOnly = true)
    public List<WebToonListResponse> findBestWebToon() {

        User user = userFacade.getCurrentUser();

        List<WebToon> findBestWebToon = webToonRepositoryImp.findMostLikedWebtoons();
        List<WebToonListResponse> findBestWebToons = findBestWebToon
                .stream()
                .map(WebToonListResponse::new)
                .collect(Collectors.toList());

        return findBestWebToons;
    }
}
