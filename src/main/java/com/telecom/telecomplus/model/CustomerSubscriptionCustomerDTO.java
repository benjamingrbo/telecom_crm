package com.telecom.telecomplus.model;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerSubscriptionCustomerDTO {
    private Long customerSubscriptionId;

    private Long customerId;

    private Long planId;

    private Long customPlanId;

    private Long deviceInfoId;

    private Long telephoneNumber;

    private Integer contractLength;

    private Date startDate;

    private String firstName;

    private String lastName;

    private String address;

    private Integer onNumberOfMonths;
}
