package com.telecom.telecomplus.controller;

import com.telecom.telecomplus.model.Payment;
import com.telecom.telecomplus.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment/getAllPayments")
    public List<Payment> getAllPayments(){
        return paymentService.getAllPayments();
    }

    @GetMapping("/payment/getPaymentById/{id}")
    public Optional<Payment> getPaymentById(@PathVariable Long id){
        return paymentService.getPaymentById(id);
    }

    @PutMapping("/payment/updatePayment/{id}")
    public Payment updatePayment(@RequestBody Payment updatedPayment, @PathVariable  Long id){
        return paymentService.updatePayment(id, updatedPayment);
    }

    @PostMapping("/payment/createPayment")
    public Payment createPayment(@RequestBody Payment newPayment){
        return paymentService.createPayment(newPayment);
    }

    @DeleteMapping("/payment/deletePayment/{id}")
    public String deletePayment(@PathVariable Long id){
        return paymentService.deletePaymentById(id);
    }
}
