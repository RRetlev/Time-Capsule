package com.codecool.timecapsule.model;

public class MessageEmail extends Email {
    public MessageEmail(String message,String address){
        this.address = address;
        this.subject="Your TimeCapsule was digged out";
        this.payload="What a journey was this \n\n" +
                "here is what you have thought at the beginning\n\n"+
                message;
    }
}
