package com.codecool.timecapsule.model;

import lombok.Data;

@Data
public abstract class Email {
    String address;

    String subject;

    String payload;
}
