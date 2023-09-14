package com.example.lezhin.domain.disLike.exception;

import com.example.lezhin.global.error.exception.BusinessException;
import com.example.lezhin.global.error.exception.ErrorCode;

public class DisLikeExistException extends BusinessException {

    public static final BusinessException EXCEPTION = new DisLikeExistException();

    private DisLikeExistException() {
        super(ErrorCode.DISLIKE_EXISTS);
    }
}
