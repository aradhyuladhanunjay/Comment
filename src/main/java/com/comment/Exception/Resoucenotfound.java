package com.comment.Exception;

public class Resoucenotfound extends RuntimeException {

    private String message;

    public Resoucenotfound(String message) {
        super(message);
        this.message = message;
    }
}
