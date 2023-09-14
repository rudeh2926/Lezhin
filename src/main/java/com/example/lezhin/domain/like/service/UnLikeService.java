package com.example.lezhin.domain.like.service;

import com.example.lezhin.domain.like.facade.LikeFacade;
import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.user.facade.UserFacade;
import com.example.lezhin.domain.webToon.domain.WebToon;
import com.example.lezhin.domain.webToon.facade.WebToonFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UnLikeService {

    private final LikeFacade likeFacade;
    private final UserFacade userFacade;
    private final WebToonFacade webToonFacade;

    @Transactional
    public void unLikeService(Long webToonId) {

        User user = userFacade.getCurrentUser();
        WebToon webToon = webToonFacade.getWebToonById(webToonId);
        boolean like = likeFacade.hasUserGivenLikeToWebToon(user, webToon);

        webToon.minusLikeCounts();
    }
}
