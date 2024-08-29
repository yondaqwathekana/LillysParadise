package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.enums.PaymentMethod;

import java.time.LocalDate;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
    public Payment findPaymentByDate(LocalDate date);
    public Payment findPaymentsByDateAfter(LocalDate dateAfter);
    public Payment readPaymentsByPaymentMethod(PaymentMethod paymentMethod);
    public Payment findPaymentsByDateBetween(LocalDate date1, LocalDate date2);
}
