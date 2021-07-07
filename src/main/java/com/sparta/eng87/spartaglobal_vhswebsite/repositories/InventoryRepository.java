package com.sparta.eng87.spartaglobal_vhswebsite.repositories;

import com.sparta.eng87.spartaglobal_vhswebsite.entities.FilmEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity,Integer> {

    @Query(value = "SELECT * FROM inventory where inventory_id = ?",nativeQuery = true)
    InventoryEntity getInventoryEntitiesByInventoryId(int inventory_id);

    @Query(value="SELECT * FROM inventory WHERE film_id=?", nativeQuery = true)
    List<InventoryEntity> getInventoryEntitiesByFilmId(int id);


    @Query(value="SELECT inventory_id FROM inventory WHERE film_id =?", nativeQuery = true)
    Integer getInventoryIdByFilmId(int id);
}
