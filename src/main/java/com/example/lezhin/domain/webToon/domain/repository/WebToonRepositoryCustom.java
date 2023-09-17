package com.example.lezhin.domain.webToon.domain.repository;

import com.example.lezhin.domain.webToon.domain.WebToon;

import java.util.List;

public interface WebToonRepositoryCustom {
    List<WebToon> findMostLikedWebtoons();
    List<WebToon> findMostDisLikedWebtoons();
}
