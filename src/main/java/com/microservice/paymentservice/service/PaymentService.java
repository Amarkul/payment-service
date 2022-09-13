package com.microservice.paymentservice.service;

import com.microservice.paymentservice.model.Payment;
import com.microservice.paymentservice.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    private Logger log = LoggerFactory.getLogger(PaymentService.class);

    public Payment doPayment(Payment payment){
        log.info("START : inside the PaymentService - doPayment method");
        payment.setStatus(paymentProcession());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }

    public String paymentProcession(){
        log.info("START : inside the PaymentService - paymentProcession method");
        return new Random().nextBoolean()?"success":"false";
    }

    public Payment findPaymentByOrderId(int orderId) {
        log.info("START : inside the PaymentService - findPaymentByOrderId method");
        return paymentRepository.findByOrderId(orderId);
    }
}
