package com.example.lezhin.domain.like.presentation;

import com.example.lezhin.domain.like.service.LikeService;
import com.example.lezhin.domain.like.service.UnLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like/{webToonId}")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;
    private final UnLikeService unLikeService;

    @PostMapping
    public void like(@PathVariable Long webToonId) {
        likeService.like(webToonId);
    }

    @DeleteMapping
    public void unLike(@PathVariable Long webToonId) {
        unLikeService.unLikeService(webToonId);
    }
}
