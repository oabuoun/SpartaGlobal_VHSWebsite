package com.sparta.eng87.spartaglobal_vhswebsite.services;

import com.sparta.eng87.spartaglobal_vhswebsite.entities.FilmEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.RentalEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.repositories.RentalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    private RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public void saveRental (FilmEntity filmEntity) {
        RentalEntity rentalEntity = new RentalEntity()
       // rentalRepository.save(filmEntityList);
    }
}
