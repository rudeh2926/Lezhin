package com.example.lezhin.domain.webToon.exception;

import com.example.lezhin.global.error.exception.BusinessException;
import com.example.lezhin.global.error.exception.ErrorCode;

public class WebToonNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new WebToonNotFoundException();

    private WebToonNotFoundException(){
        super(ErrorCode.WEBTOON_NOT_FOUND);
    }
}
