package com.example.kochamkino;


import com.example.kochamkino.models.Director;
import com.example.kochamkino.models.Grade;
import com.example.kochamkino.models.Movie;
import com.example.kochamkino.models.User;
import com.example.kochamkino.repositories.DirectorRepo;
import com.example.kochamkino.repositories.GradeRepo;
import com.example.kochamkino.repositories.MovieRepo;
import com.example.kochamkino.repositories.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Slf4j
public class DataLoader {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initDatabase(UserRepo userRepo, MovieRepo movieRepo, DirectorRepo directorRep, GradeRepo gradeRepo) {
        return args ->
        {
            User user = new User("Piotr", "Stachnio", 'm', "piotrstachnio@gmail.com", "cyta", passwordEncoder.encode("haslomaslo"));
            user.setRole("User");
            Director director = new Director("Patryk", "Vega");
            Director director2 = new Director("Tommy", "Bwoii");
            Director director3 = new Director("James", "Cameron");
            Director director4 = new Director("Jas", "Fasola");
            Director director5 = new Director("Christopher", "Nolan");
            Director director6 = new Director("Stephen", "Spillberg");
            Movie movie = new Movie("Avatar","Fantasy", director3, 2012);
            Movie movie1 = new Movie("Harry Potter","Fantasy", director, 2001);
            Movie movie2 = new Movie("Pit","Thriller", director2, 2002);
            Movie movie3 = new Movie("The Last Dance","Document", director2, 2020);
            Movie movie4 = new Movie("Titanic", "Romance", director3,1997);
            Movie movie5 = new Movie("Rocetman","Document",director4, 2020);
            Movie movie6 = new Movie("Batman: Begins", "Action",director5 ,2005);
            Movie movie7 = new Movie("Batman: The Dark Knight", "Action", director5, 2008);
            Movie movie8 = new Movie("Batman: The Dark Knight Rises", "Action", director5, 2012);
            Movie movie9 = new Movie("Jurassic Park", "Action", director6, 1993);



            //Grade grade = new Grade(10, user, movie1);

            Grade grade = new Grade(10, user, movie);
            User user2 = new User("Tom",   "Tom", 'm', "tom@gmail.com", "tom", passwordEncoder.encode("tom"));
            user2.setRole("User");
           // Grade grade1 = new Grade(9, user2, movie);
           // Grade grade2 = new Grade(2, user2, movie);

            userRepo.save(user);

            directorRep.save(director);
            directorRep.save(director2);
            directorRep.save(director3);
            directorRep.save(director4);
            directorRep.save(director5);
            directorRep.save(director6);
            movieRepo.save(movie3);
            movieRepo.save(movie4);
            movieRepo.save(movie5);
            movieRepo.save(movie6);
            movieRepo.save(movie7);
            movieRepo.save(movie8);
            movieRepo.save(movie9);



            movieRepo.save(movie);
            movieRepo.save(movie1);
            movieRepo.save(movie2);
            userRepo.save(user2);
            //gradeRepo.save(grade1);
            //gradeRepo.save(grade2);
            gradeRepo.save(grade);
        };
    }
}
