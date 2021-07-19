package com.sparta.eng87.spartaglobal_vhswebsite.repositories;

import com.sparta.eng87.spartaglobal_vhswebsite.entities.ActorEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<CategoryEntity,Integer> {
    @Query(value="Select * from category ORDER BY name",nativeQuery = true)
    List<CategoryEntity> getAllGenres();
}
