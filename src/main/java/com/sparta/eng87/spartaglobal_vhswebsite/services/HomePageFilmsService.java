package com.sparta.eng87.spartaglobal_vhswebsite.services;



import com.sparta.eng87.spartaglobal_vhswebsite.entities.FilmEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.InventoryEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.RentalEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.repositories.FilmsRepository;
import com.sparta.eng87.spartaglobal_vhswebsite.repositories.InventoryRepository;
import com.sparta.eng87.spartaglobal_vhswebsite.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomePageFilmsService {

    private FilmsRepository films;
    private InventoryRepository inventory;
    private RentalRepository rentals;

    @Autowired
    public HomePageFilmsService(FilmsRepository films,InventoryRepository inventory,RentalRepository rentals){
        this.films=films;
        this.inventory=inventory;
        this.rentals= rentals;
    }

    public List<FilmEntity> getMostRecentReturns(){
        List<RentalEntity> rentalsByReturnDate = rentals.getLatestReturns();
        List<FilmEntity> films = new ArrayList<>();
        List<InventoryEntity> returnedInventory = new ArrayList<>();
        List<Integer> filmsAlreadySelected = new ArrayList<>();
        for (RentalEntity rent:
             rentalsByReturnDate) {
            returnedInventory.add(getInventoryEntitiesByInventoryId(rent.getInventoryId()));
        }
        int i=0;
        while (films.size()<4){
            if(i<returnedInventory.size()){
                if(filmsAlreadySelected.contains(returnedInventory.get(i).getFilmId())!=true){
                    filmsAlreadySelected.add(returnedInventory.get(i).getFilmId());
                    if(getRentalEntitiesByInventoryId(returnedInventory.get(i).getInventoryId()).get(0).getReturnDate()!=null) {
                        films.add(findFilmByID(returnedInventory.get(i).getFilmId()));
                    }
                }
            }
            i++;
        }
        return films;
    }

    public FilmEntity findFilmByID(int id){
       return films.getFilmByID(id);
    }

    public InventoryEntity getInventoryEntitiesByInventoryId(int id){
        return inventory.getInventoryEntitiesByInventoryId(id);

    }

    public  List<RentalEntity> getRentalEntitiesByInventoryId(int inventoryId){
        return rentals.getRentalEntitiesByInventoryId(inventoryId);
    }


}
