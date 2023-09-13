package com.example.lezhin.domain.webToon.presentation.dto.request;

import com.example.lezhin.domain.webToon.enums.PaidType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ModifyPaidRequest {

    private Long webToonId;
    private PaidType paidType;
    private Integer price;
}
