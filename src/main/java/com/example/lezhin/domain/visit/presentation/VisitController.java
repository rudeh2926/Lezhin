package com.example.lezhin.domain.visit.presentation;

import com.example.lezhin.domain.visit.presentation.dto.VisitWebToonResponse;
import com.example.lezhin.domain.visit.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visit")
@RequiredArgsConstructor
public class VisitController {

    private final VisitService visitService;

    @GetMapping("/{webToonId}")
    public List<VisitWebToonResponse> visit(@PathVariable Long webToonId) {
        return visitService.visitWebToon(webToonId);
    }
}
