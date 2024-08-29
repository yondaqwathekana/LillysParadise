package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @Column(name = "booking_id")
    private String bookingId;

    @Column(name = "check_in")
    private LocalDateTime checkIn;

    @Column(name = "check_out")
    private LocalDateTime checkOut;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guest_id")
    private Guest guest;



    protected Booking() {
    }

    private Booking(Builder builder) {
        this.bookingId = builder.bookingId;
        this.checkIn = builder.checkIn;
        this.checkOut = builder.checkOut;
        this.room = builder.room;
        this.guest = builder.guest;
    }

    public String getBookingId() {
        return bookingId;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public Room getRoom() {
        return room;
    }

    public Guest getGuest() {
        return guest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking booking)) return false;
        return Objects.equals(getBookingId(), booking.getBookingId()) && Objects.equals(getCheckIn(), booking.getCheckIn()) && Objects.equals(getCheckOut(), booking.getCheckOut()) && Objects.equals(getRoom(), booking.getRoom()) && Objects.equals(getGuest(), booking.getGuest());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookingId(), getCheckIn(), getCheckOut(), getRoom(), getGuest());
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", room=" + room +
                ", guest=" + guest +
                '}';
    }

    public static class Builder {
        private String bookingId;
        private LocalDateTime checkIn;
        private LocalDateTime checkOut;
        private Room room;
        private Guest guest;


        public Builder setBookingId(String bookingId) {
            this.bookingId = bookingId;
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
