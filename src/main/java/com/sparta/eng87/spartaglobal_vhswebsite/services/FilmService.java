package com.sparta.eng87.spartaglobal_vhswebsite.services;

import com.sparta.eng87.spartaglobal_vhswebsite.entities.FilmEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    private FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<FilmEntity> findFilmsByTitle(String title) {
        return filmRepository.findFilmsFromTitle(title.trim());
    }

    public List<FilmEntity> findFilmsByActor(String actor) {
        if (actor.trim().contains(" ")) {
            String[] names = actor.trim().split(" ");
            return filmRepository.findFilmsFromActor(names[0], names[1]);
        } else {
            return filmRepository.findFilmsFromActor(actor.trim());
        }
    }

    public List<FilmEntity> findFilmsByGenre(String genre) {
        return filmRepository.findFilmsFromGenre(genre.trim());
    }
}
