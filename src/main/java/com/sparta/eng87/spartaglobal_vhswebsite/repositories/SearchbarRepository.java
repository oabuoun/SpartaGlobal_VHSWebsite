package com.sparta.eng87.spartaglobal_vhswebsite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchbarRepository extends JpaRepository<FilmEntity, Integer> {

    @Query(value = "SELECT f.* FROM film f WHERE f.title = ?", nativeQuery = true)
    List<FilmEntity> findFilmsFromTitle (String title);
}
