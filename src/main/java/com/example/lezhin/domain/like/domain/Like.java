package com.example.lezhin.domain.like.domain;

import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.webToon.domain.WebToon;
import com.example.lezhin.global.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Table(name = "tbl_like")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Like extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "webTonn_id")
    private WebToon webToon;
}
