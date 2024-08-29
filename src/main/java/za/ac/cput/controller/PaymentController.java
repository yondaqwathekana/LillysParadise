package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Payment;
import za.ac.cput.service.impl.PaymentServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentServiceImpl paymentService;
    @Autowired
    public PaymentController(PaymentServiceImpl paymentService) {this.paymentService = paymentService;}
    @PostMapping("/create")
    public Payment createPayment(@RequestBody Payment payment){ return paymentService.create(payment); }
    @GetMapping("/read/{paymentId}")
    public Payment readPayment(@PathVariable String paymentId){ return paymentService.read(paymentId); }
    @PutMapping("/update")
    public Payment updatePayment(@RequestBody Payment payment){ return paymentService.update(payment); }
    @GetMapping("/getallpayements")
    public Set<Payment> getAllPayments(){ return paymentService.getAll(); }
}
