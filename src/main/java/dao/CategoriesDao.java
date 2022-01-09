package dao;

import model.Categories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDao {
    private static Connection connection = ConnectMySQL.getConnection();
    private static PreparedStatement preparedStatement;

    public static List<Categories> getAllCategories(){
        String selectAll = "SELECT * FROM Categories";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectAll);

            List<Categories> categoriesList = new ArrayList<>();

            while (resultSet.next()) {
                int idCategories = resultSet.getInt("idCategories");
                String nameCategories = resultSet.getString("nameCategories");

                categoriesList.add(new Categories(idCategories, nameCategories));
            }
            return categoriesList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
