package com.example.lezhin.domain.webToon.presentation.dto.response;

import com.example.lezhin.domain.webToon.domain.WebToon;
import com.example.lezhin.domain.webToon.enums.WebToonType;
import lombok.*;

@Getter
@AllArgsConstructor
public class WebToonResponse {

    private Long id;
    private String title;
    private String content;
    private WebToonType webToonType;
    private Integer likeCount;
    private Integer disLikeCount;

    public WebToonResponse (WebToon webToon) {
        this.id = webToon.getId();
        this.title = webToon.getTitle();
        this.content = webToon.getContent();
        this.webToonType = webToon.getWebToonType();
        this.likeCount = webToon.getLikeCounts();
        this.disLikeCount = webToon.getDisLikeCounts();
    }
}
