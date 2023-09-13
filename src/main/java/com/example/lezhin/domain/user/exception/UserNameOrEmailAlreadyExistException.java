package com.example.lezhin.domain.user.exception;

import com.example.lezhin.global.error.exception.BusinessException;
import com.example.lezhin.global.error.exception.ErrorCode;

public class UserNameOrEmailAlreadyExistException extends BusinessException {

    public static final BusinessException EXCEPTION = new UserNameOrEmailAlreadyExistException();

    private UserNameOrEmailAlreadyExistException
            (){
        super(ErrorCode.USERNAME_OR_EMAIL_ALREADY_EXISTS);
    }
}
