package com.example.lezhin.domain.like.service;

import com.example.lezhin.domain.disLike.facade.DisLikeFacade;
import com.example.lezhin.domain.like.domain.Like;
import com.example.lezhin.domain.like.domain.repository.LikeRepository;
import com.example.lezhin.domain.like.exception.LikeExistException;
import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.user.facade.UserFacade;
import com.example.lezhin.domain.webToon.domain.WebToon;
import com.example.lezhin.domain.webToon.facade.WebToonFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class LikeService {

    private final UserFacade userFacade;
    private final WebToonFacade webToonFacade;
    private final DisLikeFacade disLikeFacade;
    private final LikeRepository likeRepository;

    @Transactional
    public void like(Long webToonId) {

        User user = userFacade.getCurrentUser();
        WebToon webToon = webToonFacade.getWebToonById(webToonId);


        if (likeRepository.hasUserGivenLikeToWebToon(user,webToon)) {
            throw LikeExistException.EXCEPTION;
        }

        if (disLikeFacade.hasUserGivenLikeToWebToon(user, webToon)) {
            webToon.minusDisLikeCounts();
        }

        likeRepository.save(
                Like.builder()
                        .user(user)
                        .webToon(webToon)
                        .build());

        webToon.addLikeCounts();
    }
}
