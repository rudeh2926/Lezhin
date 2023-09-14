package com.example.lezhin.domain.disLike.service;

import com.example.lezhin.domain.disLike.facade.DisLikeFacade;
import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.user.facade.UserFacade;
import com.example.lezhin.domain.webToon.domain.WebToon;
import com.example.lezhin.domain.webToon.facade.WebToonFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UnDisLikeService {

    private final UserFacade userFacade;
    private final WebToonFacade webToonFacade;
    private final DisLikeFacade disLikeFacade;

    @Transactional
    public void unDisLike(Long webToonId) {

        User user = userFacade.getCurrentUser();
        WebToon webToon = webToonFacade.getWebToonById(webToonId);

        disLikeFacade.hasUserGivenLikeToWebToon(user, webToon);
        webToon.minusDisLikeCounts();;
    }

}
