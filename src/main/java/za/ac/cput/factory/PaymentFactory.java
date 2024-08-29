package za.ac.cput.factory;

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.enums.PaymentMethod;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.time.LocalTime;

public class PaymentFactory {
    public static Payment buildPayment(String paymentId, Booking booking, PaymentMethod paymentMethod, LocalDate date, LocalTime time){
        if(Helper.isNullOrEmpty(paymentId) || Helper.isNullOrEmpty(booking) || Helper.isNullOrEmpty(paymentMethod) || Helper.isNullOrEmpty(date) || Helper.isNullOrEmpty(time))
            return null;
        return new Payment.Builder().setPaymentId(paymentId).setBooking(booking).setPaymentMethod(paymentMethod).setDate(date).setTime(time).build();
    }
}
