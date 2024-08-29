package za.ac.cput.service;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Bnb;

import java.util.List;
import java.util.UUID;

public interface BnbService extends IService<Bnb, UUID>{
    List<Bnb> getAll();
}

