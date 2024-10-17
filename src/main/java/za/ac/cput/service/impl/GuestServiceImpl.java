package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Guest;
import za.ac.cput.repository.GuestRepository;
import za.ac.cput.service.GuestService;

import java.util.List;
import java.util.UUID;

@Service
public class GuestServiceImpl implements GuestService {
    private final GuestRepository guestRepository;
    @Autowired
    public GuestServiceImpl(GuestRepository guestRepository) { this.guestRepository = guestRepository; }

    @Override
    public Guest create(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override
    public Guest read(UUID guest_id) {
        return guestRepository.findById(guest_id).orElse(null);
    }

    @Override
    public Guest update(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override
    public List<Guest> getAll() { return guestRepository.findAll(); }

}
