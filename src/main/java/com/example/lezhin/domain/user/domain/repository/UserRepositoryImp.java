package com.example.lezhin.domain.user.domain.repository;

import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.webToon.enums.WebToonType;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.lezhin.domain.user.domain.QUser.user;
import static com.example.lezhin.domain.webToon.domain.QWebToon.webToon;
import static com.example.lezhin.domain.visit.domain.QVisit.visit;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImp implements UserRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<User> findUsersWithDistinctAdultWebtoonViews() {
        LocalDateTime oneWeekAgo = LocalDateTime.now().minusWeeks(1);
        return jpaQueryFactory
                .selectFrom(user)
                .where(
                        user.in(
                                jpaQueryFactory
                                        .select(visit.user)
                                        .from(visit)
                                        .join(visit.webToon, webToon)
                                        .on(visit.visitDateTime.after(oneWeekAgo))
                                        .where(
                                                webToon.webToonType.eq(WebToonType.FORADULT).isTrue()
                                        )
                                        .groupBy(visit.user)
                                        .having(webToon.id.countDistinct().goe(3))
                                )
                         )
                .fetch();
    }
}
