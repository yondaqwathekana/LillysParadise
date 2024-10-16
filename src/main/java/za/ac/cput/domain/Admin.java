package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity
public class Admin extends User{

    @Embedded
    private Name name;
    @Embedded
    private Contact contact;

    protected Admin(){}

    public Admin(Name name, Contact contact, String email, String password){
        super(email, password);
        this.name = name;
        this.contact = contact;
    }

    public Admin(Builder builder) {
        this.name = builder.name;
        this.contact = builder.contact;
    }


    public static class Builder{
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

        public Builder copy(Admin admin){
            this.name = admin.name;
            this.contact = admin.contact;
            return this;
        }
        public Admin build(){ return new Admin(this); }
    }
}
