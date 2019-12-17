package com.codecool.timecapsule.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Integer id;

    private String username;
    @JsonIgnore
    private Long psw;

    private String email;
}
