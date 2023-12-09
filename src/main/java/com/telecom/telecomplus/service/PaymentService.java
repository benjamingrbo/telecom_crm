package com.telecom.telecomplus.service;

import com.telecom.telecomplus.model.Payment;
import com.telecom.telecomplus.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId);
    }

    public Payment updatePayment(Long paymentId, Payment updatedPayment) {
        return paymentRepository.findById(paymentId)
                .map(payment -> {

                    if (updatedPayment.getInvoice() != null) {
                        payment.setInvoice(updatedPayment.getInvoice());
                    }
                    if (updatedPayment.getPaymentMethod() != null) {
                        payment.setPaymentMethod(updatedPayment.getPaymentMethod());
                    }
                    if (updatedPayment.getPaymentDate() != null) {
                        payment.setPaymentDate(updatedPayment.getPaymentDate());
                    }

                    return paymentRepository.save(payment);
                })
                .orElse(null);
    }

    public Payment createPayment(Payment newPayment) {
        return paymentRepository.save(newPayment);
    }


    public String deletePaymentById(Long paymentId) {
        paymentRepository.deleteById(paymentId);
        return "Payment with id: " + paymentId + " has been deleted.";
    }
}
