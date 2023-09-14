package com.example.lezhin.domain.like.domain.repository;

import com.example.lezhin.domain.like.domain.DisLike;
import com.example.lezhin.domain.like.domain.Like;
import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.webToon.domain.WebToon;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DisLikeRepository extends CrudRepository<DisLike, Long> {
    Optional<DisLike> hasUserGivenDisLikeToWebToon(User user, WebToon webToon);
}
