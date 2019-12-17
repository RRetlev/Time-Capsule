package com.codecool.timecapsule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@AllArgsConstructor
@Entity
@Builder
@NoArgsConstructor
public class OneuseURL {

    @Id
    private UUID URL;

    private String email;

    //enablesceduling

}
