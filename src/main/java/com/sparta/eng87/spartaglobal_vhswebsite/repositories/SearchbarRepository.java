package com.sparta.eng87.spartaglobal_vhswebsite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchbarRepository extends JpaRepository<FilmEntity, Integer> {

    @Query(value = "SELECT f.* FROM film f WHERE f.title LIKE %?1%;", nativeQuery = true)
    List<FilmEntity> findFilmsFromTitle (String title);

    @Query(value = "SELECT f.* FROM film f " +
            "INNER JOIN film_actor fa ON f.film_id = fa.film_id" +
            "INNER JOIN actor a ON fa.actor_id = a.actor_id" +
            "WHERE a.first_name LIKE %?1% OR a.last_name LIKE %?1%", nativeQuery = true)
    List<FilmEntity> findFilmsFromActor (String name);

    @Query(value = "SELECT f.* FROM film f " +
            "INNER JOIN film_actor fa ON f.film_id = fa.film_id" +
            "INNER JOIN actor a ON fa.actor_id = a.actor_id" +
            "WHERE a.first_name LIKE %?1% AND a.last_name LIKE %?2%", nativeQuery = true)
    List<FilmEntity> findFilmsFromActor (String firstName, String lastName);

    @Query(value = "SELECT f.* FROM film f WHERE f.genre = ?", nativeQuery = true)
    List<FilmEntity> findFilmsFromGenre (String genre);
}
