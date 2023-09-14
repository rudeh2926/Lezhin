package com.example.lezhin.domain.disLike.facade;

import com.example.lezhin.domain.disLike.domain.DisLike;
import com.example.lezhin.domain.disLike.domain.repository.DisLikeRepository;
import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.webToon.domain.WebToon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class DisLikeFacade {

    private final DisLikeRepository disLikeRepository;

    public boolean hasUserGivenLikeToWebToon(User user, WebToon webToon) {
        return disLikeRepository.hasUserGivenDisLikeToWebToon(user, webToon);
    }
}
