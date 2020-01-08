package com.codecool.timecapsule.model;


public class InviteEmail extends Email {
    public InviteEmail(String url,String address){
        this.address = address;
        this.payload = "This is your Unique Invite Link for your Time Capsule \n\n" +
                "There is only one available for you so be careful\n" +
                "http://localhost:3000/invite/"+url;
        this.subject = "Time Capsule Invite Link";
    }
}
