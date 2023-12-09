package com.telecom.telecomplus.controller;

import com.telecom.telecomplus.model.PaymentMethod;
import com.telecom.telecomplus.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PaymentMethodController {
    private final PaymentMethodService paymentMethodService;

    @Autowired
    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @GetMapping("/paymentMethod/getAllPaymentMethods")
    public List<PaymentMethod> getAllPaymentMethods(){
        return paymentMethodService.getAllPaymentMethods();
    }

    @GetMapping("/paymentMethod/getPaymentMethodById/{id}")
    public Optional<PaymentMethod> getPaymentMethodById(@PathVariable Long id){
        return paymentMethodService.getPaymentMethodById(id);
    }

    @PutMapping("/paymentMethod/updatePaymentMethod/{id}")
    public PaymentMethod updatePaymentMethod(@RequestBody PaymentMethod updatedPaymentMethod, @PathVariable  Long id){
        return paymentMethodService.updatePaymentMethod(id, updatedPaymentMethod);
    }

    @PostMapping("/paymentMethod/createPaymentMethod")
    public PaymentMethod createPaymentMethod(@RequestBody PaymentMethod newPaymentMethod){
        return paymentMethodService.createPaymentMethod(newPaymentMethod);
    }

    @DeleteMapping("/paymentMethod/deletePaymentMethod/{id}")
    public String deletePaymentMethod(@PathVariable Long id){
        return paymentMethodService.deletePaymentMethodById(id);
    }
}
