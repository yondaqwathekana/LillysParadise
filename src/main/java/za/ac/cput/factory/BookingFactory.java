package za.ac.cput.factory;

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Guest;
import za.ac.cput.domain.Room;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;
import java.util.UUID;

public class BookingFactory {
    public static Booking createBooking(String bookingId, int numberOfGuest, LocalDateTime checkIn, LocalDateTime checkOut, Room room, Guest guest){
        if(Helper.isNullOrEmpty(bookingId)|| Helper.isNullOrEmpty(numberOfGuest) || Helper.isNullOrEmpty(checkIn) || Helper.isNullOrEmpty(checkOut) || Helper.isNullOrEmpty(room) || Helper.isNullOrEmpty(guest)){
            throw new IllegalArgumentException("Booking details cannot be null or empty.");
        }

        return new Booking.Builder()
                .setBookingId(bookingId)
                .setNumberOfGuest(numberOfGuest)
                .setCheckIn(checkIn)
                .setCheckOut(checkOut)
                .setRoom(room)
                .setGuest(guest)
                .build();
    }

}
