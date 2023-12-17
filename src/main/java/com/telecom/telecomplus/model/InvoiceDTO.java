package com.telecom.telecomplus.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InvoiceDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private BigDecimal totalCost;

    private Timestamp dueDate;

    private Timestamp invoiceDate;

    private String status;



}
