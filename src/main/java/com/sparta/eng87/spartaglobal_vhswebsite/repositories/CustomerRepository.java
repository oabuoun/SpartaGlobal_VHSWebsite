package com.sparta.eng87.spartaglobal_vhswebsite.repositories;

import com.sparta.eng87.spartaglobal_vhswebsite.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    @Query(value="select f.title,f.description, r.rental_date, r.return_date FROM rental r " +
            "INNER JOIN inventory i ON i.inventory_id = r.inventory_id " +
            "INNER JOIN film f ON f.film_id = i.film_id " +
            "WHERE customer_id = ?  AND r.return_date IS NULL " +
            "ORDER BY r.return_date"
            , nativeQuery = true)
    List<Object[]> getCurrentlyRentedFilmsByCustomerId(int id);


    @Query(value="select f.title, f.description, r.rental_date, r.return_date, DATEDIFF(CURDATE(), r.rental_date) FROM rental r " +
            "INNER JOIN inventory i ON i.inventory_id = r.inventory_id " +
            "INNER JOIN film f ON f.film_id = i.film_id " +
            "WHERE customer_id = ? AND r.return_date IS NOT NULL " +
            "ORDER BY r.return_date"
            , nativeQuery = true)
    List<Object[]> getPreviouslyRentedFilmsByCustomerId(int id);
}
