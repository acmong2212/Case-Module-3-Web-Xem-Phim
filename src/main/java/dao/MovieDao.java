package dao;

import model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static dao.ConnectMySQL.getConnection;

public class MovieDao {
    static Connection connection = getConnection();

    public static List<Movie> getAllMovie() {
        String sqlGetAll = "select Movie.*, Categories.nameCategories as Categories from movie\n" +
                "join categories on movie.idCategories = categories.idCategories";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAll);
            ResultSet resultSet = preparedStatement.executeQuery(sqlGetAll);

            List<Movie> movieList = new ArrayList<>();

            while (resultSet.next()) {
                int idMovie = resultSet.getInt("idMovie");
                String nameMovie = resultSet.getString("nameMovie");
                String description = resultSet.getString("description");
                int idCategories = resultSet.getInt("idCategories");
                int year = resultSet.getInt("year");
                String image = resultSet.getString("image");
                String nameCategories = resultSet.getString("Categories");

                movieList.add(new Movie(idMovie, nameMovie, description, idCategories, year, image, nameCategories));
            }
            return movieList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addMovie(Movie movie) {
        String addMovie = "INSERT INTO Movie (`nameMovie`, `description`, `idCategories`, `year`, `image`) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(addMovie);
            preparedStatement.setString(1, movie.getNameMovie());
            preparedStatement.setString(2, movie.getDescription());
            preparedStatement.setInt(3, movie.getIdCategories());
            preparedStatement.setInt(4, movie.getYear());
            preparedStatement.setString(5, movie.getImage());

            preparedStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateMovie(Movie movie) {
        String UPDATE_MOVIE_SQL = "update Movie set nameMovie = ?,description= ?, idCategories =?, year=?, image=? where (idMovie = ?);";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MOVIE_SQL);) {
            preparedStatement.setString(1, movie.getNameMovie());
            preparedStatement.setString(2, movie.getDescription());
            preparedStatement.setInt(3, movie.getIdCategories());
            preparedStatement.setInt(4, movie.getYear());
            preparedStatement.setString(5, movie.getImage());
            preparedStatement.setInt(6, movie.getIdMovie());

            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteMovie(int id) {
        String deleteMovie = "DELETE FROM Movie where idMovie = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteMovie);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Movie> findByName(String findName) {
        String findMovie = "select Movie.*, Categories.nameCategories as Categories from movie\n" +
                "join categories on movie.idCategories = categories.idCategories\n" +
                "where movie.nameMovie like '%"+findName+"%'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(findMovie);
            ResultSet resultSet = preparedStatement.executeQuery(findMovie);

            List<Movie> movieList = new ArrayList<>();

            while (resultSet.next()) {
                int idMovie = resultSet.getInt("idMovie");
                String nameMovie = resultSet.getString("nameMovie");
                String description = resultSet.getString("description");
                int idCategories = resultSet.getInt("idCategories");
                int year = resultSet.getInt("year");
                String image = resultSet.getString("image");
                String nameCategories = resultSet.getString("Categories");

                movieList.add(new Movie(idMovie, nameMovie, description, idCategories, year, image, nameCategories));
            }
            return movieList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
