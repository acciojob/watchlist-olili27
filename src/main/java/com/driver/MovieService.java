package com.driver;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    public String addMovie(Movie director) {
        return MovieRepository.addMovie(director);
    }

    public String addDirector(Director director) {
        return DirectorRepository.addDirector(director);
    }

    public String addMovieDirectorPair(String movie, String director) {
        return MovieDirectorRepository.addMovieDirectorPair(movie, director);
    }

    public Movie getMovieByName(String name) {
        List<Movie> directors = MovieRepository.getAllMovies();

        if (directors != null) {
            for (Movie director: directors) {
                if (director.getName().equals(name)) {
                    return director;
                }
            }
        }

        return null;
    }

    public Director getDirectorByName(String name) {
        List<Director> directors = DirectorRepository.getAllDirectors();

        if (directors != null) {
            for (Director director: directors) {
                if (director.getName().equals(name)) {
                    return director;
                }
            }
        }

        return null;
    }

    public List<String> getMoviesByDirectorName(String director) {
        List<String> movies = MovieDirectorRepository.getMoviesByDirectorName(director);

        if (movies == null) return null;

        return movies;
    }

    public List<String> findAllMovies() {
        List<Movie> movies = MovieRepository.getAllMovies();

        if (movies == null) return null;

        List<String> movieNames = new ArrayList<>();
        for (Movie movie: movies) {
            movieNames.add(movie.getName());
        }
        return movieNames;
    }

    public String deleteDirectorByName(String director) {
        return DirectorRepository.deleteDirector(director);
    }

    public String deleteAllDirectors() {
        List<Director> directors = DirectorRepository.getAllDirectors();

        if (directors == null) return "";

        for (Director director: directors) {
            DirectorRepository.deleteDirector(director.getName());
        }

        return "Deleted successfully";
    }
}
