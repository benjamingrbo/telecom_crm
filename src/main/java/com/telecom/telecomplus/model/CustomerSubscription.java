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
@Table(name = "CustomerSubscription")
public class CustomerSubscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @ManyToOne
    @JoinColumn(name = "custom_plan_id")
    private CustomPlan customPlan;

    @ManyToOne
    @JoinColumn(name = "device_info_id")
    private CustomerSubscriptionDeviceInfo deviceInfo;

    @Column(name = "telephone_number", nullable = false)
    private Long telephoneNumber;

    @Column(name = "contract_length", nullable = false)
    private Integer contractLength;

    @Column(name = "start_date", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date startDate;
}
