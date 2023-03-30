package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieDirectorRepository {
    static HashMap<String, List<String>> movieDirectorDb = new HashMap<>();

    static public String addMovieDirectorPair(String movie, String director) {
        if (MovieRepository.movieDb.containsKey(movie) && DirectorRepository.directorDb.containsKey(director)) {
            List<String> movies = movieDirectorDb.getOrDefault(director, new ArrayList<>());

            movies.add(movie);
            movieDirectorDb.put(director, movies);

            return "Pair added successfully";
        }

        return "";
    }

    static public List<String> getMoviesByDirectorName(String director) {
        if (movieDirectorDb.containsKey(director)) {
            return movieDirectorDb.get(director).stream().collect(Collectors.toList());
        }

        return null;
    }

    static public void deleteMovieDirectorPair(String director) {
        if (movieDirectorDb != null && movieDirectorDb.containsKey(director)) {

            List<String> movies = movieDirectorDb.get(director);
            movieDirectorDb.remove(director);

            for (String movie: movies) {
                MovieRepository.deleteMovie(movie);
            }
        }
    }
}
