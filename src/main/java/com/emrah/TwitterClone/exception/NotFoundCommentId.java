package com.emrah.TwitterClone.exception;

public class NotFoundCommentId extends RuntimeException{
    public NotFoundCommentId() {super(Message.NOT_FOUND_COMMENT_ID);
    }
}
