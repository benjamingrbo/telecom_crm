package com.telecom.telecomplus.repository;

import com.telecom.telecomplus.model.CustomerSubscriptionCustomerDTO;
import com.telecom.telecomplus.model.Invoice;
import com.telecom.telecomplus.model.InvoiceWithCustomerSubscriptionCustomerUsageDataDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    @Query(value = "SELECT new com.telecom.telecomplus.model.InvoiceWithCustomerSubscriptionCustomerUsageDataDTO (i.id, i.customerSubscriptionId, i.invoiceDate, i.dueDate, i.status, i.totalCost, cs.id, cs.customerId, cs.planId, cs.customPlanId, cs.deviceInfoId, cs.telephoneNumber, cs.contractLength, cs.startDate, c.id, c.firstName, c.lastName, c.address, ud.id, ud.dataUsage, ud.callMinutes, ud.contactedNumber, ud.timeStamp) FROM Invoice i INNER JOIN CustomerSubscription cs ON i.customerSubscriptionId = cs.id INNER JOIN Customer c ON cs.customerId = c.id INNER JOIN UsageData ud ON c.id = ud.customerId WHERE i.id = ?1")
    List<InvoiceWithCustomerSubscriptionCustomerUsageDataDTO> findInvoiceWithUsageDataByInvoiceId(Long invoiceId);
}
