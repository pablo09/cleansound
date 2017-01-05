package com.pzeszko.cleansound.exception;

import lombok.Getter;

/**
 * Base exception class
 * Created by Pawel on 2017-01-04.
 */
@Getter
public class CleansoundException extends RuntimeException{
    private final ErrorCode code;

    public CleansoundException(ErrorCode code) {
        super(code.getCode());
        this.code = code;
    }
}
