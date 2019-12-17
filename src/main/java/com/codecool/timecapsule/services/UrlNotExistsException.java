package com.codecool.timecapsule.services;

public class UrlNotExistsException extends Throwable {
    public UrlNotExistsException(String inviteId) {
        super(inviteId);
    }
}
