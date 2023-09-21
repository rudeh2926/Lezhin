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
                                        .select(user)
                                        .from(user)
                                        .join(user.visit, visit)
                                        .on(visit.visitDateTime.after(oneWeekAgo))
                                        .groupBy(user)
                                        .having(webToon.webToonType.eq(WebToonType.FORADULT).countDistinct().goe(3))
                        )
                )
                .fetch();
    }
}
