package com.telecom.telecomplus.controller;

import com.telecom.telecomplus.model.Invoice;
import com.telecom.telecomplus.model.InvoiceWithCustomerSubscriptionCustomerUsageDataDTO;
import com.telecom.telecomplus.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoice/getAllInvoices")
    public List<Invoice> getAllInvoices(){
        return invoiceService.getAllInvoices();
    }

    @GetMapping("/invoice/getInvoiceById/{id}")
    public Optional<Invoice> getInvoiceById(@PathVariable Long id){
        return invoiceService.getInvoiceById(id);
    }

    @GetMapping("/invoice/getInvoiceWithUsageDataByInvoiceId/{id}")
    public List<InvoiceWithCustomerSubscriptionCustomerUsageDataDTO> getInvoiceWithUsageDataByInvoiceId(@PathVariable Long id){
        return invoiceService.findInvoiceWithUsageDataByInvoiceId(id);
    }

    @PutMapping("/invoice/updateInvoice/{id}")
    public Invoice updateInvoice(@RequestBody Invoice updatedInvoice, @PathVariable  Long id){
        return invoiceService.updateInvoice(id, updatedInvoice);
    }

    @PostMapping("/invoice/createInvoice")
    public Invoice createInvoice(@RequestBody Invoice newInvoice){
        return invoiceService.createInvoice(newInvoice);
    }

    @DeleteMapping("/invoice/deleteInvoice/{id}")
    public String deleteInvoice(@PathVariable Long id){
        return invoiceService.deleteInvoiceById(id);
    }
}
