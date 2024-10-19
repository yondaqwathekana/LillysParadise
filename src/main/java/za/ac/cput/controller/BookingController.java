package za.ac.cput.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Guest;
import za.ac.cput.domain.Room;
import za.ac.cput.repository.BookingRepository;
import za.ac.cput.repository.RoomRepository;
import za.ac.cput.repository.UserRepository;
import za.ac.cput.service.impl.BookingServiceImpl;
import java.util.List;

@RestController
@RequestMapping("/booking")
@PreAuthorize("hasRole('ROLE_GUEST')")
public class BookingController {
    private final BookingServiceImpl bookingService;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    @Autowired
    public BookingController(BookingServiceImpl bookingService, RoomRepository roomRepository, UserRepository userRepository, BookingRepository bookingRepository) {
        this.bookingService = bookingService;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
    }
    @PostMapping("/create")
    public ResponseEntity<String> createBooking(@RequestBody Booking booking) {
        try {
            if (booking == null) {
                return ResponseEntity.badRequest().body("Booking cannot be null.");
            }
            String guestEmail = booking.getGuest().getEmail();
            if (guestEmail == null || guestEmail.isEmpty()) {
                return ResponseEntity.badRequest().body("Guest email cannot be null or empty.");
            }
            Room room = roomRepository.findById(booking.getRoom().getRoomNumber()).orElseThrow(() -> new EntityNotFoundException("Room not found"));
            Guest guest = (Guest) userRepository.findByEmail(booking.getGuest().getEmail()).orElseThrow(() -> new EntityNotFoundException("Guest not found"));

            Booking newBooking = new Booking.Builder().setNumberOfGuest(booking.getNumberOfGuest()).setCheckIn(booking.getCheckIn()).setCheckOut(booking.getCheckOut()).setRoom(room).setGuest(guest).build();

            bookingService.create(newBooking);
            return ResponseEntity.status(HttpStatus.CREATED).body("Booking created successfully.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + e.getMessage());
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
    public ResponseEntity<?> updateBooking(@RequestBody Booking booking){
        try {

            String bookingId = booking.getBookingId();
            if (bookingId == null || bookingId.isEmpty()) {
                return ResponseEntity.badRequest().body("Booking Id cannot be null or empty.");
            }
            Booking updateBooking = new Booking.Builder().setBookingId(bookingId).setNumberOfGuest(booking.getNumberOfGuest()).setCheckIn(booking.getCheckIn()).setCheckOut(booking.getCheckOut()).setRoom(booking.getRoom()).setGuest(booking.getGuest()).build();

            bookingService.update(updateBooking);
            return ResponseEntity.status(HttpStatus.OK).body("Booking updated successfully.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + e.getMessage());
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
