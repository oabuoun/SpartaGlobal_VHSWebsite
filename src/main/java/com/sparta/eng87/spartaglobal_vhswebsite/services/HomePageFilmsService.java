package com.sparta.eng87.spartaglobal_vhswebsite.services;



import com.sparta.eng87.spartaglobal_vhswebsite.entities.FilmEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.InventoryEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.RentalEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.repositories.FilmRepository;
import com.sparta.eng87.spartaglobal_vhswebsite.repositories.FilmsRepository;
import com.sparta.eng87.spartaglobal_vhswebsite.repositories.InventoryRepository;
import com.sparta.eng87.spartaglobal_vhswebsite.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomePageFilmsService {

    private FilmRepository films;
    private InventoryRepository inventory;
    private RentalRepository rentals;

    @Autowired
    public HomePageFilmsService(FilmRepository films, InventoryRepository inventory, RentalRepository rentals){
        this.films=films;
        this.inventory=inventory;
        this.rentals= rentals;
    }

    public List<FilmEntity> getMostRecentReturns(){
        List<RentalEntity> rentalsByReturnDate = rentals.getLatestReturns();
        List<FilmEntity> films = new ArrayList<>();

        List<Integer> filmsAlreadySelected = new ArrayList<>();
        int i=0;

        do {
            InventoryEntity inventoryEntity = getInventoryEntitiesByInventoryId(rentalsByReturnDate.get(i).getInventoryId());
                if(filmsAlreadySelected.contains(inventoryEntity.getFilmId())!=true){
                    filmsAlreadySelected.add(inventoryEntity.getFilmId());
                if(getRentalEntitiesByInventoryId(inventoryEntity.getInventoryId()).get(0).getReturnDate()!=null) {
                                        films.add(findFilmByID(inventoryEntity.getFilmId()));
                                    }
                }
                i++;
        }while(films.size()<3);
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
    public List<InventoryEntity> getInventoryByFilmID(int id){
        return inventory.getInventoryEntitiesByFilmId(id);
    }
    public List<FilmEntity> getRecentlyUpdated(){
        List<FilmEntity> recentlyAdded=new ArrayList<>();
        List<FilmEntity> filmsByLastUpdated= films.getRecentlyUpdated();
        int i=0;
        while (recentlyAdded.size()<3){
            List<InventoryEntity> filmsInventory = getInventoryByFilmID(filmsByLastUpdated.get(i).getFilmId());
            for (InventoryEntity inventory:
                    filmsInventory) {
                if (getRentalEntitiesByInventoryId(inventory.getInventoryId()).get(0).getReturnDate()!=null){
                    recentlyAdded.add(filmsByLastUpdated.get(i));
                    break;
                }
            }
            i++;
        }
        return recentlyAdded;
    }


}
