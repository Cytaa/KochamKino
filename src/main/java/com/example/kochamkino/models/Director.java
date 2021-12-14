package com.example.kochamkino.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "directors")
@Data
public class Director{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long directorId;

    private String firstName;
    private String lastName;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "director")
    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie){
        addMovie(movie, true);
    }

    public void addMovie(Movie movie, boolean set){
       if (movie != null){
           if(getMovies().contains(movie)){
               getMovies().set(getMovies().indexOf(movie), movie);
           }
           else{
               getMovies().add(movie);
           }
           if(set){
               movie.setDirector(this, false);
           }
       }
    }

    public void removeMovie(Movie movie){
        getMovies().remove(movie);
        movie.setDirector(null);
    }
    public Director(){}

    public Director(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Movie> getMovies(){
        return this.movies;
    }

}
