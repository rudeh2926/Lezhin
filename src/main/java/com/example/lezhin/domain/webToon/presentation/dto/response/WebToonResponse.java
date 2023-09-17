package com.example.lezhin.domain.webToon.presentation.dto.response;

import com.example.lezhin.domain.webToon.domain.WebToon;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WebToonResponse {
    private String title;
    private String content;

    public WebToonResponse(WebToon webToon) {
        this.title = webToon.getTitle();
        this.content = webToon.getContent();
    }
}
