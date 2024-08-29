package za.ac.cput.service;

import za.ac.cput.domain.Amenity;

import java.util.List;

public interface AmenityService extends IService <Amenity, String>{
    List<Amenity> getAll();

}
