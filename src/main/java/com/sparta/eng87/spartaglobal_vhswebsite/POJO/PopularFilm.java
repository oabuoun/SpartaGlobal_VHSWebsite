package com.sparta.eng87.spartaglobal_vhswebsite.POJO;
import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class PopularFilm {
     @Id
     private Integer film_id;
     private String title;
     private String description;
     private Short count;

     public PopularFilm(Integer film_id, String title, String description, Short count) {
          this.film_id = film_id;
          this.title = title;
          this.description = description;
          this.count = count;
     }

     public PopularFilm() {
     }

     public Integer getFilm_id() {
          return film_id;
     }

     public void setFilm_id(Integer film_id) {
          this.film_id = film_id;
     }

     public String getTitle() {
          return title;
     }

     public void setTitle(String title) {
          this.title = title;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public Short getCount() {
          return count;
     }

     public void setCount(Short count) {
          this.count = count;
     }
}
