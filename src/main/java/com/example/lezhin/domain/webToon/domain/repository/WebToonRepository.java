package com.example.lezhin.domain.webToon.domain.repository;

import com.example.lezhin.domain.webToon.domain.WebToon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebToonRepository extends JpaRepository<WebToon, Long> {
}
