package za.ac.cput.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;
/*Anelisiwe Ntanjana*/
@Entity
public class Contact {
    @Id
    private String email;
    private String telephone;
    private String mobile;

    protected Contact() {

    }

    public Contact(Builder build) {
        this.email = build.email;
        this.telephone = build.telephone;
        this.mobile = build.mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getMobile() {
        return mobile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact contact)) return false;
        return Objects.equals(getEmail(), contact.getEmail()) && Objects.equals(getTelephone(), contact.getTelephone()) && Objects.equals(getMobile(), contact.getMobile());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getTelephone(), getMobile());
    }

    @Override
    public String toString() {
        return "Contact{" +
                "email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    public static class Builder {
        private String email;
        private String telephone;
        private String mobile;


        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setTelephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        public Builder setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder copy(Contact contact) {
            this.email = contact.email;
            this.telephone = contact.telephone;
            this.mobile = contact.mobile;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }

    }
}