package com.example.lezhin.domain.disLike.presentation;

import com.example.lezhin.domain.disLike.service.DisLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RequestMapping("/dislike/{webToonId}")
@RequiredArgsConstructor
public class DisLikeController {

    private final DisLikeService disLikeService;

    @PostMapping
    public void disLike(@PathVariable Long webToonId) {
        disLikeService.disLike(webToonId);
    }
}
