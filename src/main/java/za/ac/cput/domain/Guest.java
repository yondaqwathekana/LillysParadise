package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "guest_id")
    private UUID guest_id;

    @Embedded
    private Name name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email")
    private Contact contact;

    private String password;

    protected Guest() {}

    public Guest(Builder builder) {
        if (builder == null) {
            throw new IllegalArgumentException("Builder cannot be null");
        }
        this.guest_id = builder.guest_id;
        this.name = builder.name;
        this.contact = builder.contact;
        this.password = builder.password;
    }

    public UUID getId() {
        return guest_id;
    }

    public String getIdAsString() {
        return guest_id.toString();
    }

    public Name getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Guest guest = (Guest) object;
        return Objects.equals(guest_id, guest.guest_id) &&
                Objects.equals(name, guest.name) &&
                Objects.equals(contact, guest.contact) &&
                Objects.equals(password, guest.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guest_id, name, contact, password);
    }

    @Override
    public String toString() {
        return "Guest{" +
                "guest_id=" + guest_id +
                ", name=" + name +
                ", contact=" + contact +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder {
        private UUID guest_id;
        private Name name;
        private Contact contact;
        private String password;

        public Builder setGuest_id(UUID guest_id) {
            this.guest_id = guest_id;
            return this;
        }

        public Builder setName(Name name) {
            this.name = name;
            return this;
        }

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder copy(Guest guest) {
            this.guest_id = guest.guest_id;
            this.name = guest.name;
            this.contact = guest.contact;
            this.password = guest.password;
            return this;
        }

        public Guest build() {
            if (guest_id == null) {
                throw new IllegalStateException("guest_id cannot be null");
            }
            return new Guest(this);
        }
    }
}
