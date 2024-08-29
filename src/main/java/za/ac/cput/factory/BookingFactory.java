package za.ac.cput.factory;

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Guest;
import za.ac.cput.domain.Room;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

public class BookingFactory {
    public static Booking createBooking(String bookingId, LocalDateTime checkIn, LocalDateTime checkOut, Room room, Guest guest){
        if(Helper.isNullOrEmpty(bookingId) || Helper.isNullOrEmpty(checkIn) || Helper.isNullOrEmpty(checkOut) || Helper.isNullOrEmpty(room) || Helper.isNullOrEmpty(guest)){
            throw new IllegalArgumentException("Booking details cannot be null or empty.");
        }

        return new Booking.Builder()
                .setBookingId(bookingId)
                .setCheckIn(checkIn)
                .setCheckOut(checkOut)
                .setRoom(room)
                .setGuest(guest)
                .build();
    }

}
