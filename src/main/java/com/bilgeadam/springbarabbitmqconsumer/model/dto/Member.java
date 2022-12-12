package com.bilgeadam.springbarabbitmqconsumer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private String firstName;
    private String lastName;
    private String email;
    private Date birthOfDate;
}
