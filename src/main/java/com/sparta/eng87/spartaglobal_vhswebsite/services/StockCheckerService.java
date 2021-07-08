package com.sparta.eng87.spartaglobal_vhswebsite.services;


import com.sparta.eng87.spartaglobal_vhswebsite.entities.FilmEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.InventoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockCheckerService {

    private FilmService filmService;
    private HomePageFilmsService homePageFilmsService;

    @Autowired
    public StockCheckerService(FilmService filmService, HomePageFilmsService homePageFilmsService){
    this.filmService=filmService;
    this.homePageFilmsService=homePageFilmsService;
    }

    public List<Boolean> isInStock(List<FilmEntity> films){
        List<Boolean> inStock = new ArrayList<>();
        for( FilmEntity film :  films){
          List<InventoryEntity> filmsInventory = homePageFilmsService.getInventoryByFilmID(film.getFilmId());
            if(filmsInventory.size()==0){
              inStock.add(false);
            }
                    for (InventoryEntity inventory:
                            filmsInventory) {
                        if (homePageFilmsService.getRentalEntitiesByInventoryId(inventory.getInventoryId()).get(0).getReturnDate()!=null){
                            inStock.add(true);
                            break;
                        }
                        if(inventory.equals(filmsInventory.get(filmsInventory.size()-1))){
                            inStock.add(false);
                        }
                    }
         }
      return inStock;
    }

    public Integer getStock(List<FilmEntity> films){
        for( FilmEntity film :  films){
            List<InventoryEntity> filmsInventory = homePageFilmsService.getInventoryByFilmID(film.getFilmId());
            for (InventoryEntity inventory:
                    filmsInventory) {
                if (homePageFilmsService.getRentalEntitiesByInventoryId(inventory.getInventoryId()).get(0).getReturnDate()!=null){
                    return inventory.getInventoryId();
                }
            }
        }
        return 0;
    }
}
