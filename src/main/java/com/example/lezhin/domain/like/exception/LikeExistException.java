package com.example.lezhin.domain.like.exception;

import com.example.lezhin.global.error.exception.BusinessException;
import com.example.lezhin.global.error.exception.ErrorCode;

public class LikeExistException extends BusinessException {

    public static final BusinessException EXCEPTION = new  LikeExistException();

    private LikeExistException() {
        super(ErrorCode.LIKE_EXISTS);
    }
}
