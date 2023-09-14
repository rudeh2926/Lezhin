package com.example.lezhin.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {


    EMAIL_NOT_FOUND(404, "User Not Found"),
    USERNAME_OR_EMAIL_ALREADY_EXISTS(409, "UserName Or EMAIL Already Exists"),
    PASSWORD_MISS_MATCH(400, "Password Miss Match"),

    WEBTOON_NOT_FOUND(404, "WebToon Not Found"),

    LIKE_EXISTS(409, "Star Exists"),
    DISLIKE_EXISTS(409, "DisLike Exists"),

    JWT_EXPIRED(401, "Jwt Expired"),
    JWT_INVALID(401, "Jwt Invalid"),

    BAD_REQUEST(400, "Bad request"),
    INTERNAL_SERVER_ERROR(500, "Internal server error");

    private final Integer statusCode;
    private final String message;
}