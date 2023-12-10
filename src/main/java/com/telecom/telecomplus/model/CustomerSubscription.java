package com.telecom.telecomplus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customersubscription")
public class CustomerSubscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Long customerId;


    private Long planId;


    private Long customPlanId;


    private Long deviceInfoId;

    @Column(name = "telephone_number", nullable = false)
    private Long telephoneNumber;

    @Column(name = "contract_length", nullable = false)
    private Integer contractLength;

    @Column(name = "start_date", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date startDate;
}
