package com.emrah.TwitterClone.exception;

public class NotFoundUserId extends RuntimeException {
    public NotFoundUserId() {
        super("USER " + Message.NOT_FOUND_ID);
    }
}
