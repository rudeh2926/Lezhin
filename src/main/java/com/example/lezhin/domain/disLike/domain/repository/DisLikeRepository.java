package com.example.lezhin.domain.disLike.domain.repository;

import com.example.lezhin.domain.disLike.domain.DisLike;
import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.webToon.domain.WebToon;
import org.springframework.data.repository.CrudRepository;

public interface DisLikeRepository extends CrudRepository<DisLike, Long> {
    boolean findUserGivenDisLikeToWebToon(User user, WebToon webToon);
}
