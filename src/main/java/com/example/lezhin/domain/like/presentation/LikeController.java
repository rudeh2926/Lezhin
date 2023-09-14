package com.example.lezhin.domain.like.presentation;

import com.example.lezhin.domain.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like/{webToonId}")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping
    public void like(@PathVariable Long webToonId) {
        likeService.like(webToonId);
    }
}
