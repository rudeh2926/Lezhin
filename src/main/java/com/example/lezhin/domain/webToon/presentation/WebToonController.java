package com.example.lezhin.domain.webToon.presentation;

import com.example.lezhin.domain.webToon.presentation.dto.request.ModifyPaidRequest;
import com.example.lezhin.domain.webToon.service.ModifyPaidService;
import com.example.lezhin.domain.webToon.service.WriteWebToonService;
import com.example.lezhin.domain.webToon.presentation.dto.request.WriteWebToonRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webtoon")
@RequiredArgsConstructor
public class WebToonController {

    private final WriteWebToonService writeWebToonService;
    private final ModifyPaidService modifyPaidService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void writeWebToon(WriteWebToonRequest writeWebToonRequest) {
        writeWebToonService.writeWebToon(writeWebToonRequest);
    }

    @PatchMapping
    public void modifyWebToon(ModifyPaidRequest modifyPaidRequest) {
        modifyPaidService.modifyWebToonPaid(modifyPaidRequest);
    }
}
