package com.example.lezhin.domain.like.service;

import com.example.lezhin.domain.like.domain.DisLike;
import com.example.lezhin.domain.like.domain.Like;
import com.example.lezhin.domain.like.domain.repository.DisLikeRepository;
import com.example.lezhin.domain.like.domain.repository.LikeRepository;
import com.example.lezhin.domain.like.exception.LikeExistException;
import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.user.facade.UserFacade;
import com.example.lezhin.domain.webToon.domain.WebToon;
import com.example.lezhin.domain.webToon.facade.WebToonFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final UserFacade userFacade;
    private final WebToonFacade webToonFacade;
    private final DisLikeRepository disLikeRepository;
    private final LikeRepository likeRepository;

    public void like(Long webToonId) {

        User user = userFacade.getCurrentUser();
        WebToon webToon = webToonFacade.getWebToonById(webToonId);


        if (likeRepository.hasUserGivenLikeToWebToon(user,webToon).isPresent()) {
            throw LikeExistException.EXCEPTION;
        }

        Optional<DisLike> existDisLike = disLikeRepository.hasUserGivenDisLikeToWebToon(user, webToon);
        if (existDisLike.isPresent()) {
            disLikeRepository.delete(existDisLike.get());
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
