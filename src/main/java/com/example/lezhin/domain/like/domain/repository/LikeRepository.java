package com.example.lezhin.domain.like.domain.repository;

import com.example.lezhin.domain.like.domain.Like;
import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.webToon.domain.WebToon;
import org.springframework.data.repository.CrudRepository;

public interface LikeRepository extends CrudRepository<Like, Long> {
    boolean findByUserAndWebToon(User user, WebToon webToon);
}
