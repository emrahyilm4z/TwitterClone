package com.emrah.TwitterClone.exception;

public class NotFoundUserName extends RuntimeException {
    public NotFoundUserName() {
        super(Message.NOT_FOUND_USERNAME);
    }
}
