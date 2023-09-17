package com.example.lezhin.domain.visit.domain.repository;

import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.visit.domain.Visit;
import com.example.lezhin.domain.webToon.domain.WebToon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {
   List<Visit> findByWebToonId(WebToon webToon);
   boolean existsByUserNameAndWebToon(User user, WebToon webToon);

   List<Visit> deleteVisitByUserAndWebToon(User user, WebToon webToon);
}
