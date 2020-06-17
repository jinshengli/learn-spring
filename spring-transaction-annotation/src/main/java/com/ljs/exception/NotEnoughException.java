package com.ljs.exception;

/**
 * create by ljs on 2020/6/17 7:13
 * <p>
 * description:
 */
public class NotEnoughException extends RuntimeException {


    public NotEnoughException() {

        super();
    }

    public NotEnoughException(String message) {
        super(message);
    }
}
