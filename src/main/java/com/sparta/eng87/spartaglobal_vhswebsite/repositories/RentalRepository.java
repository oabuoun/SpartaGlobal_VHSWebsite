package com.sparta.eng87.spartaglobal_vhswebsite.repositories;

import com.sparta.eng87.spartaglobal_vhswebsite.POJO.PopularFilm;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<RentalEntity, Integer>{
    @Query(value = "SELECT * FROM rental r ORDER BY r.return_date DESC", nativeQuery = true)
    List<RentalEntity> getLatestReturns();

    @Query(value = "SELECT * FROM rental WHERE inventory_id=? ORDER BY return_date", nativeQuery = true)
    List<RentalEntity> getRentalEntitiesByInventoryId(int inventoryId);

    @Query(value="SELECT f.film_id, f.title, f.description, count(*) AS 'total_rents' FROM rental r " +
            "INNER JOIN inventory i ON r.inventory_id = i.inventory_id " +
            "INNER JOIN film f ON i.film_id = f.film_id " +
            "WHERE rental_date > (SELECT(date_sub((SELECT max(rental_date)),INTERVAL 1 YEAR))) " +
            "GROUP BY f.film_id " +
            "ORDER BY total_rents DESC", nativeQuery = true)
    List<Object[]> getMostPopularRentals();

    @Query(value = "SELECT r.rental_date FROM rental r " +
            "INNER JOIN inventory i on r.inventory_id = i.inventory_id " +
            "WHERE i.film_id = ?1 AND r.return_date IS NULL " +
            "ORDER BY rental_date LIMIT 1; ", nativeQuery = true)
    Timestamp whenInStock(int film_id);

}
