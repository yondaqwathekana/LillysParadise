package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Payment;
import za.ac.cput.repository.PaymentRepository;
import za.ac.cput.service.PaymentService;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;
    @Autowired
    public PaymentServiceImpl(PaymentRepository repository) { this.repository = repository; }

    @Override
    public Payment create(Payment payment) { return repository.save(payment); }
    @Override
    public Payment read(String paymentId) { return repository.findById(paymentId).orElseThrow(()-> new NoSuchElementException("No such payment with specified id exist")); }
    @Override
    public Payment update(Payment payment) { return repository.save(payment); }
    @Override
    public Set<Payment> getAll() { return new HashSet<>(repository.findAll()); }
}
