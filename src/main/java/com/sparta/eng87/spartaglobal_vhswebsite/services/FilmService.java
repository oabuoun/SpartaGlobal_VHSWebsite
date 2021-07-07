package com.sparta.eng87.spartaglobal_vhswebsite.services;

import com.sparta.eng87.spartaglobal_vhswebsite.POJO.AdvancedSearchTerms;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.CustomerEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.FilmEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@Service
public class FilmService {

    private FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    private AdvancedSearchTerms search = new AdvancedSearchTerms();

    public List<FilmEntity> findFilmsByTitle(String title) {
//        ExampleMatcher matcher = ExampleMatcher.matchingAny().withMatcher("title", contains());
//        FilmEntity filmEntity = FilmEntity.builder().title(title).build();
//        return filmRepository.findAll(Example.of(filmEntity, matcher));
        search.setTitle(title);
        return filter(search.getFirstName(), search.getFirstName(), search.getTitle(), search.getGenre());
    }

    public List<FilmEntity> findFilmsByActor(String actor) {
        if (actor.trim().contains(" ")) {
            String[] names = actor.trim().split(" ");
            search.setFirstName(names[0]);
            search.setLastName(names[1]);
        } else {
            search.setLastName(actor);
            search.setLastName(actor);
        }
        return filter(search.getFirstName(), search.getFirstName(), search.getTitle(), search.getGenre());
    }

    public List<FilmEntity> findFilmsByGenre(String genre) {
//        FilmEntity filmEntity = FilmEntity.builder().
//        filmRepository.findAll(Example.of());
//        //return filmRepository.findFilmsFromGenre(genre.trim());
        search.setGenre(genre);
       return filter(search.getFirstName(), search.getFirstName(), search.getTitle(), search.getGenre());
    }

    public List<FilmEntity> filter(String firstName, String lastName, String title, String genre){
        return filmRepository.findFilmsFromFilter(firstName, lastName, title, genre);
    }

    public void save(FilmEntity filmEntity){
        filmRepository.save(filmEntity);
    }

    public FilmEntity findFilmByID(int id){
        return filmRepository.getFilmByID(id);
    }

//    public List<FilmEntity> getMostRecentReturns(){
//
//        return FilmRepository.findByMostRecentReturns();
//    }
}
