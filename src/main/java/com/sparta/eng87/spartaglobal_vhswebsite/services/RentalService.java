package com.sparta.eng87.spartaglobal_vhswebsite.services;

import com.sparta.eng87.spartaglobal_vhswebsite.entities.FilmEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.InventoryEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.RentalEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.repositories.InventoryRepository;
import com.sparta.eng87.spartaglobal_vhswebsite.repositories.RentalRepository;
import org.apache.coyote.Request;
import org.springframework.stereotype.Service;
import com.sparta.eng87.spartaglobal_vhswebsite.repositories.LoginRepository;
import java.security.Principal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RentalService {

    private RentalRepository rentalRepository;
    private InventoryRepository inventoryRepository;
    private LoginRepository loginRepository;

    public RentalService(RentalRepository rentalRepository, InventoryRepository inventoryRepository, LoginRepository loginRepository) {
        this.rentalRepository = rentalRepository;
        this.inventoryRepository = inventoryRepository;
        this.loginRepository=loginRepository;
    }

    public void saveRental (Integer inventoryId, Principal principal) {
        RentalEntity rentalEntity = new RentalEntity(
                Timestamp.valueOf(LocalDateTime.now()),
                        inventoryId,
                        loginRepository.findCustomerIdByUsername(principal.getName()),
                        null,
                        1,
                Timestamp.valueOf(LocalDateTime.now()));

        rentalRepository.save(rentalEntity);
    }
}
