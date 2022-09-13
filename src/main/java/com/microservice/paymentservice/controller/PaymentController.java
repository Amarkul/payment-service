package com.microservice.paymentservice.controller;

import com.microservice.paymentservice.model.Payment;
import com.microservice.paymentservice.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    private Logger log = LoggerFactory.getLogger(PaymentController.class);

    @PostMapping("/dopayment")
    public Payment doPayment(@RequestBody Payment payment){
        log.info("START : inside the PaymentController - doPayment method");
        return paymentService.doPayment(payment);
    }

    @GetMapping("/{orderId}")
    public Payment findPaymentByOrderId(@PathVariable("orderId") int orderId){
        log.info("START : inside the PaymentController - findPaymentByOrderId method");
        return paymentService.findPaymentByOrderId(orderId);
    }
}

