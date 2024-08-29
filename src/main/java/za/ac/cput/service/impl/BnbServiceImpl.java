package za.ac.cput.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Bnb;
import za.ac.cput.repository.BnbRepository;
import za.ac.cput.service.BnbService;

import java.util.List;
import java.util.UUID;

@Service
public class BnbServiceImpl implements BnbService {
    private final BnbRepository repository;

    @Autowired
    BnbServiceImpl(BnbRepository repository){
        this.repository = repository;
    }

    @Override
    public Bnb create(Bnb bnb) {
        return repository.save(bnb);
    }

    @Override
    public Bnb read(UUID bnbId) {
        return repository.findById(bnbId).orElse(null);
    }

    @Override
    public Bnb update(Bnb bnb) {
        return repository.save(bnb);
    }

    @Override
    public List<Bnb> getAll() {
        return repository.findAll();
    }
}
