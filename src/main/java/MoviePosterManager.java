package ru.netology;

import java.lang.invoke.StringConcatException;

public class MoviePosterManager {

    private String[] movies = new String[0];
    private int limit;

    public MoviePosterManager() {
        limit = 10;
    }

    public MoviePosterManager(int limit) {
        this.limit = limit;
    }

    public void save(String movie) {
        String[] tmp = new String[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public String[] findAll() {
        return movies;
    }

    public String[] findLast() {
        int resultNumber;
        if (limit < movies.length) {
            resultNumber = limit;
            } else {
            resultNumber = movies.length;
        }

        String[] result = new String[resultNumber];
        for (int i = 0; i < resultNumber; i++) {
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }
}
