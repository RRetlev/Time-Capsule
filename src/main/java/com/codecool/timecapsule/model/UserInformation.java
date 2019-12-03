package com.codecool.timecapsule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserInformation {
    @Id
    @GeneratedValue
    private Long ID;

    private String Username;

    private Long psw;

    @Email
    private String email;
}
