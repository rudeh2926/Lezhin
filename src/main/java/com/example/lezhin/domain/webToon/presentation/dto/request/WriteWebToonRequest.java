package com.example.lezhin.domain.webToon.presentation.dto.request;

import com.example.lezhin.domain.webToon.enums.PaidType;
import com.example.lezhin.domain.webToon.enums.WebToonType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WriteWebToonRequest {

    private String title;
    private String content;
    private Integer price;
    private PaidType paidType;
    private WebToonType webToonType;
}
