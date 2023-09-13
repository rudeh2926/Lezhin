package com.example.lezhin.domain.webToon.domain;

import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.webToon.enums.PaidType;
import com.example.lezhin.domain.webToon.enums.WebToonType;
import com.example.lezhin.global.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class WebToon extends BaseEntity {

    private String title;

    private String content;

    private Integer price;

    @Enumerated(EnumType.STRING)
    private WebToonType webToonType;

    @Enumerated(EnumType.STRING)
    private PaidType paidType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Integer likeCounts;

    private Integer disLikeCounts;

    public void modifyPaid(PaidType paidType, Integer price) {
        this.paidType = paidType;
        this.price = price;
    }
}
