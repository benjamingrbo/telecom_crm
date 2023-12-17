package com.telecom.telecomplus.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private Long genderId;

    private Long locationId;

    private Long occupationId;

    private String city;

    private String district;

    private String gender;

    private String occupationName;


}
