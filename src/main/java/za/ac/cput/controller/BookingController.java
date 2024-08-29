package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Booking;
import za.ac.cput.service.impl.BookingServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingServiceImpl bookingService;
    @Autowired
    public BookingController(BookingServiceImpl bookingService) {
        this.bookingService = bookingService;
    }
    @PostMapping("/create")
    public Booking createBooking(@RequestBody Booking booking){
        return bookingService.create(booking);
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

}
