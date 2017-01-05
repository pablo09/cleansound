package com.pzeszko.cleansound.exception;

/**
 * Created by Pawel on 2017-01-05.
 */
public class NotFoundException extends CleansoundException{

    public NotFoundException() {
        super(ErrorCode.NOT_FOUND);
    }
}
