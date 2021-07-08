package com.sparta.eng87.spartaglobal_vhswebsite.services;

import com.sparta.eng87.spartaglobal_vhswebsite.entities.ActorEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.CategoryEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.repositories.ActorRepository;
import com.sparta.eng87.spartaglobal_vhswebsite.repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilterService {

    private ActorRepository actors;
    private GenreRepository genres;

    public FilterService(ActorRepository actors, GenreRepository genres) {
        this.actors = actors;
        this.genres = genres;
    }

    public List<CategoryEntity> getAllGenres(){
        return genres.getAllGenres();
    }

    public List<ActorEntity> getAllActors(){
        return actors.getAllActors();
    }
}
