package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieRepository {
    static HashMap<String, Movie> movieDb = new HashMap<>();

    static public String addMovie(Movie movie) {
        String key = movie.getName();
        movieDb.put(key, movie);

        return "Movie added successfully";
    }

    static public List<Movie> getAllMovies() {
        if (movieDb == null) return null;

        return movieDb.values().stream().collect(Collectors.toList());
    }

    static public void deleteMovie(String name) {
        if (movieDb != null && movieDb.containsKey(name)) {
            movieDb.remove(name);
        }
    }
}
