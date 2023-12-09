package com.telecom.telecomplus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_subscription_id", nullable = false)
    private CustomerSubscription customerSubscription;

    @Column(name = "invoice_date", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date invoiceDate;

    @Column(name = "due_date", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date dueDate;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "total_cost", nullable = false)
    private BigDecimal totalCost;
}
