package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.MoviePosterManager;

public class MoviePosterManagerTest {

    String movie1 = "Бладщот";
    String movie2 = "Вперед";
    String movie3 = "Отель Белград";
    String movie4 = "Джентельмены";
    String movie5 = "Человек-невидимка";
    String movie6 = "Тролли. Мировой тур";
    String movie7 = "Номер один";


    @Test
    public void shouldFindAllMovies() {

        MoviePosterManager manager = new MoviePosterManager();

        manager.save(movie1);
        manager.save(movie2);
        manager.save(movie3);
        manager.save(movie4);
        manager.save(movie5);
        manager.save(movie6);
        manager.save(movie7);

        String[] expected = {movie1, movie2, movie3, movie4, movie5, movie6, movie7};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllMoviesFromTheLastLimit() {

        MoviePosterManager manager = new MoviePosterManager(10);

        manager.save(movie1);
        manager.save(movie2);
        manager.save(movie3);
        manager.save(movie4);
        manager.save(movie5);
        manager.save(movie6);
        manager.save(movie7);

        String[] expected = {movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllMoviesFromTheLastUnderLimit() {

        MoviePosterManager manager = new MoviePosterManager(6);

        manager.save(movie1);
        manager.save(movie2);
        manager.save(movie3);
        manager.save(movie4);
        manager.save(movie5);
        manager.save(movie6);
        manager.save(movie7);

        String[] expected = {movie7, movie6, movie5, movie4, movie3, movie2};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllMoviesFromTheLastAboveLimit() {

        MoviePosterManager manager = new MoviePosterManager(11);

        manager.save(movie1);
        manager.save(movie2);
        manager.save(movie3);
        manager.save(movie4);
        manager.save(movie5);
        manager.save(movie6);
        manager.save(movie7);

        String[] expected = {movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
