package com.example.lezhin.domain.webToon.domain.repository;

import com.example.lezhin.domain.webToon.domain.WebToon;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.lezhin.domain.webToon.domain.QWebToon.webToon;

@Repository
@RequiredArgsConstructor
public class WebToonRepositoryImp implements WebToonRepositoryCustom{

    private final JPAQueryFactory  jpaQueryFactory;

    @Override
    public List<WebToon> findMostLikedWebtoons() {
        return jpaQueryFactory
                .selectFrom(webToon)
                .orderBy(webToon.likeCounts.desc())
                .limit(3)
                .fetch();
    }

    @Override
    public List<WebToon> findMostDisLikedWebtoons() {
        return jpaQueryFactory
                .selectFrom(webToon)
                .orderBy(webToon.disLikeCounts.desc())
                .limit(3)
                .fetch();
    }
}
