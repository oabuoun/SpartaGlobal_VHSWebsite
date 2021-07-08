package com.sparta.eng87.spartaglobal_vhswebsite.repositories;

import com.sparta.eng87.spartaglobal_vhswebsite.entities.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {

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

    @Query(value = "SELECT f.* FROM film f " +
            "INNER JOIN film_category fc ON f.film_id = fc.film_id" +
            "INNER JOIN category c ON fc.category_id = c.category_id" +
            "WHERE c.name = ?", nativeQuery = true)
    List<FilmEntity> findFilmsFromGenre (String genre);

    @Query(value = "SELECT f.* FROM film f " +
            "INNER JOIN film_actor fa ON f.film_id = fa.film_id " +
            "INNER JOIN actor a ON fa.actor_id = a.actor_id " +
            "INNER JOIN film_category fc ON f.film_id = fc.film_id " +
            "INNER JOIN category c ON fc.category_id = c.category_id " +
            "WHERE (a.first_name LIKE %?1% OR a.last_name LIKE %?2%) " +
            "AND f.title LIKE %?3% " +
            "AND c.name LIKE %?4% " +
            "GROUP BY f.title", nativeQuery = true)
    List<FilmEntity> findFilmsFromFilter (String firstName, String lastName, String title, String genre);

    @Query(value = "SELECT f.* FROM film f " +
            "INNER JOIN film_actor fa ON f.film_id = fa.film_id " +
            "INNER JOIN actor a ON fa.actor_id = a.actor_id " +
            "INNER JOIN film_category fc ON f.film_id = fc.film_id " +
            "INNER JOIN category c ON fc.category_id = c.category_id " +
            "WHERE concat(a.first_name,a.last_name) IN (?1) " +
            "AND f.title LIKE %?2% " +
            "AND c.name IN (?3) " +
            "GROUP BY f.title", nativeQuery = true)
    List<FilmEntity> findFilmsFromCheckbox (String actor, String title, String genre);

    @Query(value = "select * From film where film_id=?",nativeQuery = true)
    FilmEntity getFilmByID(int ID);

    @Query(value="SELECT * FROM film ORDER BY last_update", nativeQuery = true)
    List<FilmEntity> getRecentlyUpdated();


}

