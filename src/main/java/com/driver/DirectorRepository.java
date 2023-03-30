package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DirectorRepository {
    static HashMap<String, Director> directorDb = new HashMap<>();

    static public String addDirector(Director director) {
        String key = director.getName();
        directorDb.put(key, director);

        return "Director added successfully";
    }

    static public List<Director> getAllDirectors() {
        if (directorDb == null) return null;

        return directorDb.values().stream().collect(Collectors.toList());
    }

    static public String deleteDirector(String name) {
        if (directorDb != null && directorDb.containsKey(name)) {
            directorDb.remove(name);

            MovieDirectorRepository.deleteMovieDirectorPair(name);

            return "Deleted successfully";
        }

        return "";
    }
}
