package com.pzeszko.cleansound.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INTERNAL_ERROR("INTERNAL_ERROR"),
    NOT_FOUND("NOT_FOUND");

    private final String code;

}
