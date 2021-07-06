package com.sparta.eng87.spartaglobal_vhswebsite.repositories;

import com.sparta.eng87.spartaglobal_vhswebsite.entities.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<RentalEntity, Integer>{
    @Query(value = "SELECT * FROM rental r ORDER BY r.return_date DESC", nativeQuery = true)
    List<RentalEntity> getLatestReturns();

    @Query(value = "SELECT * FROM rental WHERE inventory_id=?", nativeQuery = true)
    List<RentalEntity> getRentalEntitiesByInventoryId(int inventoryId);


}
