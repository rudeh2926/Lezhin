package com.example.lezhin.domain.webToon.service;

import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.user.facade.UserFacade;
import com.example.lezhin.domain.visit.domain.Visit;
import com.example.lezhin.domain.visit.domain.repository.VisitRepository;
import com.example.lezhin.domain.webToon.domain.WebToon;
import com.example.lezhin.domain.webToon.facade.WebToonFacade;
import com.example.lezhin.domain.webToon.presentation.dto.response.WebToonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FindWebToonService {

    private final UserFacade userFacade;
    private final VisitRepository visitRepository;
    private final WebToonFacade webToonFacade;

    @Transactional
    public WebToonResponse findWebToon(Long webToonId) {

        User user = userFacade.getCurrentUser();
        WebToon webToon = webToonFacade.getWebToonById(webToonId);

        if (visitRepository.existsByUserNameAndWebToon(user, webToon)) {
            visitRepository.deleteVisitByUserAndWebToon(user, webToon);
        }

        visitRepository.save(
                Visit.builder()
                        .user(user)
                        .webToon(webToon)
                        .visitDateTime(LocalDateTime.now())
                        .build());

        return new WebToonResponse(webToon);
    }

}
