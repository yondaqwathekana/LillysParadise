package za.ac.cput.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Guest;
import za.ac.cput.domain.Room;
import za.ac.cput.service.impl.BookingServiceImpl;
import za.ac.cput.service.impl.GuestServiceImpl;
import za.ac.cput.service.impl.RoomServiceImp;

import java.io.IOException;
import java.rmi.server.UID;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private final BookingServiceImpl bookingService;
    @Autowired
    public BookingController(BookingServiceImpl bookingService) {
        this.bookingService = bookingService;
    }
    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking){
        try {
            Booking createdBooking = bookingService.create(booking);
            return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/read/{bookingId}")
    public Booking readBooking(@PathVariable String bookingId){
        return bookingService.read(bookingId);
    }
    @PutMapping("/update")
    public Booking updateBooking(@RequestBody Booking booking){
        return bookingService.update(booking);
    }
    @GetMapping("/getall")
    public List<Booking> getAllBookings(){
        return bookingService.getAll();
    }
    @GetMapping("/{roomNumber}")
    public List<Booking> findBookingsByRoomNumber(@PathVariable String roomNumber){ return bookingService.findBookingsByRoomNumber(roomNumber); }

}
