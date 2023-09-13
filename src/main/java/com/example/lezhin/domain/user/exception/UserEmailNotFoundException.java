package com.example.lezhin.domain.user.exception;

import com.example.lezhin.global.error.exception.BusinessException;
import com.example.lezhin.global.error.exception.ErrorCode;

public class UserEmailNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new UserEmailNotFoundException();

    private UserEmailNotFoundException(){
        super(ErrorCode.EMAIL_NOT_FOUND);
    }

}