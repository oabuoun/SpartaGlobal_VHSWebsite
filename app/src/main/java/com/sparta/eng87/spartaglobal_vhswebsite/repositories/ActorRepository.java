package com.sparta.eng87.spartaglobal_vhswebsite.repositories;

import com.sparta.eng87.spartaglobal_vhswebsite.entities.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<ActorEntity,Integer> {
    @Query(value="Select * from actor ORDER BY first_name",nativeQuery = true)
    List<ActorEntity> getAllActors();

}
