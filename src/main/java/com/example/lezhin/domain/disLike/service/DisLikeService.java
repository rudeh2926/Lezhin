package com.example.lezhin.domain.disLike.service;

import com.example.lezhin.domain.disLike.domain.DisLike;
import com.example.lezhin.domain.disLike.domain.repository.DisLikeRepository;
import com.example.lezhin.domain.disLike.exception.DisLikeExistException;
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
public class DisLikeService {

    private final UserFacade userFacade;
    private final WebToonFacade webToonFacade;
    private final LikeFacade likeFacade;
    private final DisLikeRepository disLikeRepository;

    @Transactional
    public void disLike(Long webToonId) {

        User user = userFacade.getCurrentUser();
        WebToon webToon = webToonFacade.getWebToonById(webToonId);

        if (disLikeRepository.findByUserAndWebToon(user, webToon)) {
            throw DisLikeExistException.EXCEPTION;
        }

        if (likeFacade.hasUserGivenLikeToWebToon(user, webToon)) {
            webToon.minusLikeCounts();
        }

        disLikeRepository.save(
                DisLike.builder()
                        .user(user)
                        .webToon(webToon)
                        .build());

        webToon.addDisLikeCounts();

    }
}
