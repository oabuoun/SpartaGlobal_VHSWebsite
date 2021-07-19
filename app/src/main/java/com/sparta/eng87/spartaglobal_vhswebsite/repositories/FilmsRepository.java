package com.sparta.eng87.spartaglobal_vhswebsite.repositories;

import com.sparta.eng87.spartaglobal_vhswebsite.entities.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmsRepository extends JpaRepository<FilmEntity,Integer> {







}
