package com.telecom.telecomplus.service;

import com.telecom.telecomplus.model.PaymentMethod;
import com.telecom.telecomplus.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodService {
    private final PaymentMethodRepository paymentMethodRepository;

    @Autowired
    public PaymentMethodService(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodRepository.findAll();
    }

    public Optional<PaymentMethod> getPaymentMethodById(Long paymentMethodId) {
        return paymentMethodRepository.findById(paymentMethodId);
    }

    public PaymentMethod updatePaymentMethod(Long paymentMethodId, PaymentMethod updatedPaymentMethod) {
        return paymentMethodRepository.findById(paymentMethodId)
                .map(paymentMethod -> {

                    if (updatedPaymentMethod.getPaymentMethod() != null) {
                        paymentMethod.setPaymentMethod(updatedPaymentMethod.getPaymentMethod());
                    }

                    return paymentMethodRepository.save(paymentMethod);
                })
                .orElse(null);
    }

    public PaymentMethod createPaymentMethod(PaymentMethod newPaymentMethod) {
        return paymentMethodRepository.save(newPaymentMethod);
    }


    public String deletePaymentMethodById(Long paymentMethodId) {
        paymentMethodRepository.deleteById(paymentMethodId);
        return "PaymentMethod with id: " + paymentMethodId + " has been deleted.";
    }
}
