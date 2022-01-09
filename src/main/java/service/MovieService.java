package service;

import dao.MovieDao;
import model.Movie;

import java.util.List;

public class MovieService {
    public static List<Movie> movieList = MovieDao.getAllMovie();

    public List<Movie> fillAllMovie(){
        movieList = MovieDao.getAllMovie();
        return movieList;
    }

    public void createMovie(Movie movie) {
        MovieDao.addMovie(movie);
        movieList = MovieDao.getAllMovie();
    }

    public void editMovie(Movie movie) {
        MovieDao.updateMovie(movie);
        movieList = MovieDao.getAllMovie();
    }

    public void deleteMovie(int id) {
        MovieDao.deleteMovie(id);
        movieList = MovieDao.getAllMovie();
    }

    public Movie getMovieById(int id){
        for (Movie movie : movieList) {
            if (movie.getIdMovie() == id) {
                return movie;
            }
        }
        return null;
    }

    public List<Movie> findByName(String name){
        movieList = MovieDao.findByName(name);
        return movieList;
    }
}
