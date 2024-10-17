package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Booking;
import za.ac.cput.service.impl.BookingServiceImpl;
import java.util.List;
@RestController
@RequestMapping("/booking")
@PreAuthorize("hasRole('ROLE_GUEST')")
public class BookingController {
    private final BookingServiceImpl bookingService;
    @Autowired
    public BookingController(BookingServiceImpl bookingService) {
        this.bookingService = bookingService;
    }
    @PostMapping("/create")
    public ResponseEntity<?> createBooking(@RequestBody Booking booking){
        try {
            Booking createdBooking = bookingService.create(booking);
            return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/read/{bookingId}")
    public ResponseEntity<Booking> readBooking(@PathVariable String bookingId){
        try {
            Booking readBooking = bookingService.read(bookingId);
            return new ResponseEntity<>(readBooking, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update")
    public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking){
        try {
            Booking updateBooking = bookingService.update(booking);
            return new ResponseEntity<>(updateBooking, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Booking>> getAllBookings(){
        try {
            List<Booking> bookings = bookingService.getAll();
            return new ResponseEntity<>(bookings, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/{roomNumber}")
    public ResponseEntity<List<Booking>> findBookingsByRoomNumber(@PathVariable String roomNumber){
        try {
            List<Booking> bookings = bookingService.findBookingsByRoomNumber(roomNumber);
            return new ResponseEntity<>(bookings, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
