package za.ac.cput.domain;

import jakarta.persistence.Embeddable;


import java.io.Serializable;
import java.util.Objects;

/* Address.java
Address model class
Author: Luyanda
*/

@Embeddable
public class Address implements Serializable {
    private String streetName;
    private String city;
    private String postalCode;

    public Address() {
    }

    private Address(Builder builder) {
        this.streetName = builder.streetName;
        this.city = builder.city;
        this.postalCode = builder.postalCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(streetName, address.streetName) &&
                Objects.equals(city, address.city) &&
                Objects.equals(postalCode, address.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetName, city, postalCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    public static class Builder {

        private String streetName;
        private String city;
        private String postalCode;


        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Address build() {
            return new Address(this);
        }

        public Builder copy(Address address) {
            if (address != null) {
                this.streetName = address.streetName;
                this.city = address.city;
                this.postalCode = address.postalCode;
            }
            return this;
        }
    }
}
