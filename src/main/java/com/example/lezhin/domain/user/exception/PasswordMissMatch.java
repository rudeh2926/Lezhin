package com.example.lezhin.domain.user.exception;

import com.example.lezhin.global.error.exception.BusinessException;
import com.example.lezhin.global.error.exception.ErrorCode;

public class PasswordMissMatch extends BusinessException {

    public static final BusinessException EXCEPTION = new PasswordMissMatch();

    private PasswordMissMatch(){
        super(ErrorCode.PASSWORD_MISS_MATCH);
    }
}
