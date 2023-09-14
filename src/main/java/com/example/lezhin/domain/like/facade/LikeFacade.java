package com.example.lezhin.domain.like.facade;

import com.example.lezhin.domain.like.domain.Like;
import com.example.lezhin.domain.like.domain.repository.LikeRepository;
import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.webToon.domain.WebToon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class LikeFacade {

    private final LikeRepository likeRepository;

    public Optional<Like> hasUserGivenLikeToWebToon(User user, WebToon webToon) {
       return likeRepository.hasUserGivenLikeToWebToon(user, webToon);
    }
}
