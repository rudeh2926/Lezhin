package com.example.lezhin.domain.webToon.service;

import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.domain.user.facade.UserFacade;
import com.example.lezhin.domain.webToon.domain.WebToon;
import com.example.lezhin.domain.webToon.enums.PaidType;
import com.example.lezhin.domain.webToon.facade.WebToonFacade;
import com.example.lezhin.domain.webToon.presentation.dto.request.ModifyPaidRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ModifyPaidService {

    private final WebToonFacade webToonFacade;
    private final UserFacade userFacade;

    @Transactional
    public void modifyWebToonPaid(ModifyPaidRequest modifyPaidRequest) {

        User user = userFacade.getCurrentUser();
        WebToon webToon = webToonFacade.getWebToonById(modifyPaidRequest.getWebToonId());

        if (PaidType.FREE.equals(modifyPaidRequest.getPaidType())) {
            webToon.modifyPaid(modifyPaidRequest.getPaidType(), 0);
        } else if (PaidType.PAID.equals(modifyPaidRequest.getPaidType())) {
            webToon.modifyPaid(modifyPaidRequest.getPaidType(), modifyPaidRequest.getPrice());
        }
    }
}
