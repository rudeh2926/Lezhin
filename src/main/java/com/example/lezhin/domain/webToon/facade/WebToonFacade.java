package com.example.lezhin.domain.webToon.facade;

import com.example.lezhin.domain.webToon.domain.WebToon;
import com.example.lezhin.domain.webToon.domain.repository.WebToonRepository;
import com.example.lezhin.domain.webToon.exception.WebToonNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class WebToonFacade {

    private final WebToonRepository webToonRepository;

    public WebToon getWebToonById(Long webToonId) {
        return webToonRepository.findById(webToonId)
                .orElseThrow(() -> WebToonNotFoundException.EXCEPTION);
    }
}
