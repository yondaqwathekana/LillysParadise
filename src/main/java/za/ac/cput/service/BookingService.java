package za.ac.cput.service;

import za.ac.cput.domain.Booking;

import java.util.List;
import java.util.UUID;

public interface BookingService extends IService<Booking, String>{
    List<Booking> getAll();

}
