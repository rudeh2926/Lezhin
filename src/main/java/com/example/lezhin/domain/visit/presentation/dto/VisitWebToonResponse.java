package com.example.lezhin.domain.visit.presentation.dto;

import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.visit.domain.Visit;
import com.example.lezhin.domain.webToon.domain.WebToon;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class VisitWebToonResponse {

    private WebToon webToon;
    private User user;
    private LocalDateTime visitDateTime;

    public VisitWebToonResponse(Visit visit) {
        webToon = visit.getWebToon();
        user = visit.getUser();
        visitDateTime = visit.getVisitDateTime();
    }
}
