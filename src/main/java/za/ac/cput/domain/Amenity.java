package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Entity
public class Amenity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String amenityId;
    private String name;
    private String description;
    private boolean availability;

    protected Amenity() {
    }

    private Amenity(Builder builder) {
        this.amenityId = builder.amenityId;
        this.name = builder.name;
        this.description = builder.description;
        this.availability = builder.availability;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Amenity amenity = (Amenity) object;
        return availability == amenity.availability && Objects.equals(amenityId, amenity.amenityId) && Objects.equals(name, amenity.name) && Objects.equals(description, amenity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amenityId, name, description, availability);
    }

    @Override
    public String toString() {
        return "Amenity{" +
                "amenityId='" + amenityId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", availability=" + availability +
                '}';
    }

    public static class Builder {
        private String amenityId;
        private String name;
        private String description;
        private boolean availability;

        public Builder setAmenityId(String amenityId) {
            this.amenityId = amenityId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setAvailability(boolean availability) {
            this.availability = availability;
            return this;
        }

        public Builder copy(Amenity a) {
            this.amenityId = a.amenityId;
            this.name = a.name;
            this.description = a.description;
            this.availability = a.availability;
            return this;
        }

        public Amenity build() {
            return new Amenity(this);
        }

    }
}
