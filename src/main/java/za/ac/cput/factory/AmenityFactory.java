package za.ac.cput.factory;

import za.ac.cput.domain.Amenity;
import za.ac.cput.util.Helper;

import java.util.Set;

public class AmenityFactory {
    public static Amenity createAmenity(String amenityId, String name, String description, boolean availability) {
        if (Helper.isNullOrEmpty(amenityId) || Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(description) || Helper.isNullOrEmpty(availability)) {
            throw new IllegalArgumentException("Amenities cannot be null or empty");
        }

        return new Amenity.Builder()
                .setAmenityId(amenityId)
                .setName(name)
                .setDescription(description)
                .setAvailability(availability)
                .build();
        }

}

