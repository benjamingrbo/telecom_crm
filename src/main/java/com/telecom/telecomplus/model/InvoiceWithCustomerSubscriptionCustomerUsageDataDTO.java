package com.telecom.telecomplus.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class InvoiceWithCustomerSubscriptionCustomerUsageDataDTO {

    private Long invoiceId;
    private Long invoiceCustomerSubscriptionId;
    private Timestamp invoiceDate;
    private Timestamp dueDate;
    private String invoiceStatus;
    private BigDecimal totalCost;
    private Long customerSubscriptionId;
    private Long customerSubscriptionCustomerId;
    private Long customerSubscriptionPlanId;
    private Long customerSubscriptionCustomPlanId;
    private Long customerSubscriptionDeviceInfoId;
    private Long customerSubscriptionTelephoneNumber;
    private Integer customerSubscriptionContractLength;
    private Timestamp customerSubscriptionStartDate;
    private Long customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerAddress;
    private Long usageDataId;
    private BigDecimal dataUsage;
    private BigDecimal callMinutes;
    private Long contactedNumber;
    private Timestamp timestamp;

}
