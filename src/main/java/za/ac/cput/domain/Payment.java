package za.ac.cput.domain;

import jakarta.persistence.*;
import za.ac.cput.domain.enums.PaymentMethod;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Payment {
    @Id
    private String paymentId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_id")
    private Booking booking;
    private PaymentMethod paymentMethod;
    private LocalDate date;
    private LocalTime time;

    protected Payment(){}

    public Payment(Builder builder) {
        this.paymentId = builder.paymentId;
        this.booking = builder.booking;
        this.paymentMethod = builder.paymentMethod;
        this.date = builder.date;
        this.time = builder.time;
    }

    public String getPaymentId() { return paymentId; }
    public Booking getBooking() { return booking; }
    public PaymentMethod getPaymentMethod() { return paymentMethod; }
    public LocalDate getDate() { return date; }
    public LocalTime getTime() { return time; }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Payment payment = (Payment) object;
        return Objects.equals(paymentId, payment.paymentId) && Objects.equals(booking, payment.booking) && paymentMethod == payment.paymentMethod && Objects.equals(date, payment.date) && Objects.equals(time, payment.time);
    }
    @Override
    public int hashCode() { return Objects.hash(paymentId, booking, paymentMethod, date, time); }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", booking=" + booking +
                ", paymentMethod=" + paymentMethod +
                ", date=" + date +
                ", time=" + time +
                '}';
    }

    public static class Builder {
        private String paymentId;
        private Booking booking;
        private PaymentMethod paymentMethod;
        private LocalDate date;
        private LocalTime time;

        public Builder setPaymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }
        public Builder setBooking(Booking booking) {
            this.booking = booking;
            return this;
        }

        public Builder setPaymentMethod(PaymentMethod paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }
        public Builder setTime(LocalTime time) {
            this.time = time;
            return this;
        }
        public Builder copy(Payment payment) {
            this.paymentId = payment.paymentId;
            this.booking = payment.booking;
            this.paymentMethod = payment.paymentMethod;
            this.date = payment.date;
            this.time = payment.time;
            return this;
        }
        public Payment build(){ return new Payment(this); }
    }
}
