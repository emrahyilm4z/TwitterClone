package com.emrah.TwitterClone.exception;

public class CantFollow extends RuntimeException {
    public CantFollow() {
        super(Message.CANT_FOLLOW_YOURSELF);
    }
}
