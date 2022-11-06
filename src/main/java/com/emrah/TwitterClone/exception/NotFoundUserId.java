package com.emrah.TwitterClone.exception;

public class NotFoundUserId extends RuntimeException {
    public NotFoundUserId() {
        super(Message.ID_BULUNAMADI);
    }
}
