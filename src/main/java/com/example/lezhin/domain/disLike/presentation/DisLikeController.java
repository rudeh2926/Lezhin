package com.example.lezhin.domain.disLike.presentation;

import com.example.lezhin.domain.disLike.service.DisLikeService;
import com.example.lezhin.domain.disLike.service.UnDisLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RequestMapping("/dislike/{webToonId}")
@RequiredArgsConstructor
public class DisLikeController {

    private final DisLikeService disLikeService;
    private final UnDisLikeService unDisLikeService;

    @PostMapping
    public void disLike(@PathVariable Long webToonId) {
        disLikeService.disLike(webToonId);
    }

    @DeleteMapping
    public void unDisLike(@PathVariable Long webToonId) {
        unDisLikeService.unDisLike(webToonId);
    }
}
