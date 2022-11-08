package com.emrah.TwitterClone.exception;

public class NotFoundTweetID extends RuntimeException{
    public NotFoundTweetID() {super("TWEET "+Message.NOT_FOUND_ID);}
}
