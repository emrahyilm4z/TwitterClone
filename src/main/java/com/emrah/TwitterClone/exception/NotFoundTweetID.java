package com.emrah.TwitterClone.exception;

public class NotFoundTweetID extends RuntimeException{
    public NotFoundTweetID() {
        super(Message.ID_BULUNAMADI);
    }
}
