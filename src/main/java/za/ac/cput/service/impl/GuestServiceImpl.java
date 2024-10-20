package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Guest;
import za.ac.cput.domain.User;
import za.ac.cput.repository.GuestRepository;
import za.ac.cput.repository.UserRepository;
import za.ac.cput.service.GuestService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GuestServiceImpl implements GuestService {
    private final GuestRepository guestRepository;
    private final UserRepository userRepository;
    @Autowired
    public GuestServiceImpl(GuestRepository guestRepository, UserRepository userRepository) { this.guestRepository = guestRepository;
        this.userRepository = userRepository;
    }

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

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

}
