package com.example.lezhin.domain.like.facade;

import com.example.lezhin.domain.like.domain.DisLike;
import com.example.lezhin.domain.like.domain.repository.DisLikeRepository;
import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.webToon.domain.WebToon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class DisLikeFacade {

    private final DisLikeRepository disLikeRepository;

    public Optional<DisLike> hasUserGivenLikeToWebToon(User user, WebToon webToon) {
        return disLikeRepository.hasUserGivenDisLikeToWebToon(user, webToon);
    }
}
