package com.example.lezhin.domain.visit.service;

import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.user.facade.UserFacade;
import com.example.lezhin.domain.visit.domain.repository.VisitRepository;
import com.example.lezhin.domain.visit.presentation.dto.VisitWebToonResponse;
import com.example.lezhin.domain.webToon.domain.WebToon;
import com.example.lezhin.domain.webToon.facade.WebToonFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final WebToonFacade webToonFacade;
    private final UserFacade userFacade;
    private final VisitRepository visitRepository;

    public List<VisitWebToonResponse> visitWebToon(Long webToonId) {

        User user = userFacade.getCurrentUser();
        WebToon webToon = webToonFacade.getWebToonById(webToonId);

        return visitRepository.findByWebToonId(webToon).stream()
                .map(VisitWebToonResponse::new)
                .collect(Collectors.toList());
    }
}
