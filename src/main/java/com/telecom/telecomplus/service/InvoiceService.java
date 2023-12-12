package com.telecom.telecomplus.service;

import com.telecom.telecomplus.model.Invoice;
import com.telecom.telecomplus.model.InvoiceWithCustomerSubscriptionCustomerUsageDataDTO;
import com.telecom.telecomplus.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Optional<Invoice> getInvoiceById(Long invoiceId) {
        return invoiceRepository.findById(invoiceId);
    }

    public List<InvoiceWithCustomerSubscriptionCustomerUsageDataDTO> findInvoiceWithUsageDataByInvoiceId(Long invoiceId){
        return invoiceRepository.findInvoiceWithUsageDataByInvoiceId(invoiceId);
    }

    public Invoice updateInvoice(Long invoiceId, Invoice updatedInvoice) {
        return invoiceRepository.findById(invoiceId)
                .map(invoice -> {

                    if (updatedInvoice.getCustomerSubscriptionId() != null) {
                        invoice.setCustomerSubscriptionId(updatedInvoice.getCustomerSubscriptionId());
                    }
                    if (updatedInvoice.getInvoiceDate() != null) {
                        invoice.setInvoiceDate(updatedInvoice.getInvoiceDate());
                    }
                    if (updatedInvoice.getDueDate() != null) {
                        invoice.setDueDate(updatedInvoice.getDueDate());
                    }
                    if (updatedInvoice.getStatus() != null) {
                        invoice.setStatus(updatedInvoice.getStatus());
                    }
                    if (updatedInvoice.getTotalCost() != null) {
                        invoice.setTotalCost(updatedInvoice.getTotalCost());
                    }

                    return invoiceRepository.save(invoice);
                })
                .orElse(null);
    }

    public Invoice createInvoice(Invoice newInvoice) {
        return invoiceRepository.save(newInvoice);
    }


    public String deleteInvoiceById(Long invoiceId) {
        invoiceRepository.deleteById(invoiceId);
        return "Invoice with id: " + invoiceId + " has been deleted.";
    }
}
