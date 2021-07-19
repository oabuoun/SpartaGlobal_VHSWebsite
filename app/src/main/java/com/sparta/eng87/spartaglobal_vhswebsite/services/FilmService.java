package com.sparta.eng87.spartaglobal_vhswebsite.services;

import com.sparta.eng87.spartaglobal_vhswebsite.POJO.AdvancedSearchTerms;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.FilmEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.repositories.FilmRepository;
import com.sparta.eng87.spartaglobal_vhswebsite.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService {

    private FilmRepository filmRepository;
    private RentalRepository rentalRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository, RentalRepository rentalRepository) {
        this.filmRepository = filmRepository;
        this.rentalRepository = rentalRepository;
    }

    private AdvancedSearchTerms search = new AdvancedSearchTerms();

    public List<FilmEntity> findFilmsByTitle(String title) {
        search.setTitle(title);
        search.setFirstName("");
        search.setLastName("");
        search.setGenre("");
        return filter(search.getFirstName(), search.getFirstName(), search.getTitle(), search.getGenre());
    }

    public List<FilmEntity> findFilmsByActor(String actor) {
        if (actor.trim().contains(" ")) {
            String[] names = actor.trim().split(" ");
            search.setFirstName(names[0]);
            search.setLastName(names[1]);
        } else {
            search.setFirstName(actor);
            search.setLastName(actor);
        }
        search.setGenre("");
        search.setTitle("");
        return filter(search.getFirstName(), search.getFirstName(), search.getTitle(), search.getGenre());
    }

    public List<FilmEntity> findFilmsByGenre(String genre) {
        search.setGenre(genre);
        search.setFirstName("");
        search.setLastName("");
        search.setTitle("");
        return filter(search.getFirstName(), search.getFirstName(), search.getTitle(), search.getGenre());
    }


    public List<FilmEntity> filter(List<String> actors, String title, List<String> genre){
        return filmRepository.findFilmsFromCheckbox(actors, title, genre);
    }
    public List<FilmEntity> filter(String firstName,String lastName, String title, String genre){

        return filmRepository.findFilmsFromFilter(firstName, lastName, title, genre);
    }

    public void save(FilmEntity filmEntity) {
        filmRepository.save(filmEntity);
    }


    public List<FilmEntity> filterFilmsByTitle(String title) {
        search.setTitle(title);
        return filter(search.getFirstName(), search.getFirstName(), search.getTitle(), search.getGenre());
    }

    public List<FilmEntity> filterFilmsByActor(String actor) {
        if (actor.trim().contains(" ")) {
            String[] names = actor.trim().split(" ");
            search.setFirstName(names[0]);
            search.setLastName(names[1]);
        } else {
            search.setFirstName(actor);
            search.setLastName(actor);
        }
        return filter(search.getFirstName(), search.getFirstName(), search.getTitle(), search.getGenre());
    }

    public List<FilmEntity> filterFilmsByGenre(String genre) {
        search.setGenre(genre);
        return filter(search.getFirstName(), search.getFirstName(), search.getTitle(), search.getGenre());

    }

    public FilmEntity findFilmByID(int id) {
        return filmRepository.getFilmByID(id);
    }

    public List<String> whenInStock(List<FilmEntity> filmEntityList, List<Boolean> inStock) {

        List<String> backWhen = new ArrayList<>();
        for (int i = 0; i < filmEntityList.size(); i++) {
            if (!inStock.get(i)) {
                if(rentalRepository.whenInStock(filmEntityList.get(i).getFilmId())!=null){
                Timestamp temp = rentalRepository.whenInStock(filmEntityList.get(i).getFilmId());
                temp.setTime(temp.getTime() + 604800000);
                backWhen.add("Date due back: "+temp.toString().substring(0,11));}
                else{
                    backWhen.add("No Inventory");
                }

            } else backWhen.add("stock");
        }
        return backWhen;

    }
}
