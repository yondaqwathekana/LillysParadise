package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Entity
@EqualsAndHashCode
@ToString
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String bookingId;
    private int numberOfGuest;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private Room room;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guest_id")
    private Guest guest;

    protected Booking() { }

    private Booking(Builder builder) {
        this.bookingId = builder.bookingId;
        this.numberOfGuest = builder.numberOfGuest;
        this.checkIn = builder.checkIn;
        this.checkOut = builder.checkOut;
        this.room = builder.room;
        this.guest = builder.guest;
    }

    public static class Builder {
        private String bookingId;
        private int numberOfGuest;
        private LocalDateTime checkIn;
        private LocalDateTime checkOut;
        private Room room;
        private Guest guest;


        public Builder setBookingId(String bookingId) {
            this.bookingId = bookingId;
            return this;
        }
        public Builder setNumberOfGuest(int numberOfGuest) {
            this.numberOfGuest = numberOfGuest;
            return this;
        }

        public Builder setCheckIn(LocalDateTime checkIn) {
            this.checkIn = checkIn;
            return this;
        }

        public Builder setCheckOut(LocalDateTime checkOut) {
            this.checkOut = checkOut;
            return this;
        }

        public Builder setRoom(Room room) {
            this.room = room;
            return this;
        }

        public Builder setGuest(Guest guest) {
            this.guest = guest;
            return this;
        }

        public Builder copy(Booking b) {
            this.bookingId = b.bookingId;
            this.numberOfGuest = b.numberOfGuest;
            this.checkIn = b.checkIn;
            this.checkOut = b.checkOut;
            this.room = b.room;
            this.guest = b.guest;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }
    }
}
