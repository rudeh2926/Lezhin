package com.example.lezhin.domain.webToon.service;

import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.user.facade.UserFacade;
import com.example.lezhin.domain.webToon.domain.WebToon;
import com.example.lezhin.domain.webToon.domain.repository.WebToonRepository;
import com.example.lezhin.domain.webToon.presentation.dto.request.WriteWebToonRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WriteWebToonService {

    private final UserFacade userFacade;
    private final WebToonRepository webToonRepository;

    public void writeWebToon(WriteWebToonRequest writeWebToonRequest) {

        User user = userFacade.getCurrentUser();

        webToonRepository.save(
                WebToon.builder()
                        .user(user)
                        .title(writeWebToonRequest.getTitle())
                        .content(writeWebToonRequest.getContent())
                        .price(writeWebToonRequest.getPrice())
                        .likeCounts(0)
                        .disLikeCounts(0)
                        .webToonType(writeWebToonRequest.getWebToonType())
                        .paidType(writeWebToonRequest.getPaidType())
                        .build());
    }
}
