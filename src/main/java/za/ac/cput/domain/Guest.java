package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Getter
@Entity
public class Guest extends User{

    @Embedded
    private Name name;
    @Embedded
    private Contact contact;

    public Guest(Name name, Contact contact, String email, String password) {
        super(email, password);
        this.name = name;
        this.contact = contact;
    }

    protected Guest(){}

    public Guest(Builder builder) {
        if (builder == null) {
            throw new IllegalArgumentException("Builder cannot be null");
        }
        this.name = builder.name;
        this.contact = builder.contact;
    }

    public static class Builder {
        private Name name;
        private Contact contact;

        public Builder setName(Name name) {
            this.name = name;
            return this;
        }

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }


        public Builder copy(Guest guest) {
            this.name = guest.name;
            this.contact = guest.contact;
            return this;
        }

        public Guest build() {
            return new Guest(this);
        }
    }
}
