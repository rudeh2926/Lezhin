package com.example.lezhin.domain.webToon.presentation;

import com.example.lezhin.domain.webToon.presentation.dto.request.ModifyPaidRequest;
import com.example.lezhin.domain.webToon.presentation.dto.response.WebToonListResponse;
import com.example.lezhin.domain.webToon.presentation.dto.response.WebToonResponse;
import com.example.lezhin.domain.webToon.service.*;
import com.example.lezhin.domain.webToon.presentation.dto.request.WriteWebToonRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webtoon")
@RequiredArgsConstructor
public class WebToonController {

    private final WriteWebToonService writeWebToonService;
    private final ModifyPaidService modifyPaidService;
    private final BestWebToonService bestWebToonService;
    private final WorstWebToonService worstWebToonService;
    private final FindWebToonService findWebToonService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void writeWebToon(@RequestBody WriteWebToonRequest writeWebToonRequest) {
        writeWebToonService.writeWebToon(writeWebToonRequest);
    }

    @PatchMapping
    public void modifyWebToon(@RequestBody ModifyPaidRequest modifyPaidRequest) {
        modifyPaidService.modifyWebToonPaid(modifyPaidRequest);
    }

    @GetMapping("/best")
    public List<WebToonListResponse> findBestWebToon() {
        return bestWebToonService.findBestWebToon();
    }

    @GetMapping("/worst")
    public List<WebToonListResponse> findWorstWevbToon() {
        return worstWebToonService.findWorstWebToon();
    }

    @GetMapping("/{webToonId}")
    public WebToonResponse findWebToon(@PathVariable Long webToonId) {
       return findWebToonService.findWebToon(webToonId);
    }
}
