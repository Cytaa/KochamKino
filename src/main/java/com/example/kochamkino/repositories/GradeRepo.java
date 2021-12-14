package com.example.kochamkino.repositories;

import com.example.kochamkino.models.Grade;
import com.example.kochamkino.models.Movie;
import com.example.kochamkino.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepo extends JpaRepository<Grade, Long> {
    List<Grade> findByUsersId(User user);
    List<Grade> findByValue(int value);
    List<Grade> findByValueBetween(int value1, int value2);
    Grade findByMovie(Movie movie);
}
