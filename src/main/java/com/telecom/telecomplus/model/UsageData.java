package com.telecom.telecomplus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.security.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usagedata")
public class UsageData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "data_usage", nullable = false)
    private BigDecimal dataUsage;

    @Column(name = "call_minutes", nullable = false)
    private BigDecimal callMinutes;

    @Column(name = "contacted_number", nullable = false)
    private Long contactedNumber;

    @Column(name = "time_stamp", nullable = false)
    private Timestamp timeStamp;
}
