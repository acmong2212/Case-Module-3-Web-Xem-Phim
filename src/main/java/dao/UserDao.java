package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private Connection connection = ConnectMySQL.getConnection();

    public List<User> getAllCategory() {
        String sqlGetAllCategory = "SELECT * FROM user";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlGetAllCategory);
            List<User> userList = new ArrayList<>();
            while (resultSet.next()) {
                int idUser = resultSet.getInt("idUser");
                String nameUser = resultSet.getString("nameUser");
                String passUser = resultSet.getString("passUser");
                String phoneNumber = resultSet.getString("phoneNumber");
                int isPremium = resultSet.getInt("isPremium");
                int isUser = resultSet.getInt("isUser");
                int isAdmin = resultSet.getInt("isAdmin");
                int keyCode = resultSet.getInt("keyCode");

                userList.add(new User(idUser, nameUser, passUser, phoneNumber, isPremium, isUser, isAdmin, keyCode));
            }
            return userList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createUser(User user) {
        String sqlCreateUser = "INSERT INTO `user` (`nameUser`, `passUser`, `phoneNumber`, `isPremium`, `isUser`, `isAdmin`,`keyCode`) VALUES ( ?, ?, ?, ?, ?, ?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreateUser);
            createNewUser(user, preparedStatement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteUser(int id) {
        String sqlDeleteUser = "DELETE FROM `user` WHERE (`idUser` =?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDeleteUser);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        String sqlUpdateUser = "UPDATE `user` SET `nameUser` = ?, `passUser` = ?, `phoneNumber` = ?, `isPremium` = ?, `isUser` = ?, `isAdmin` =?, `keyCode` = ? WHERE (`idUser` = ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdateUser);
            preparedStatement.setString(1, user.getNameUser());
            preparedStatement.setString(2, user.getPassUser());
            preparedStatement.setString(3, user.getPhoneNumber());
            preparedStatement.setInt(4, user.getIsPremium());
            preparedStatement.setInt(5, user.getIsUser());
            preparedStatement.setInt(6, user.getIsAdmin());
            preparedStatement.setInt(7, user.getKeyCode());
            preparedStatement.setInt(8, user.getIdUser());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createNewUser(User user, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, user.getNameUser());
        preparedStatement.setString(2, user.getPassUser());
        preparedStatement.setString(3, user.getPhoneNumber());
        preparedStatement.setInt(4, user.getIsPremium());
        preparedStatement.setInt(5, user.getIsUser());
        preparedStatement.setInt(6, user.getIsAdmin());
        preparedStatement.setInt(7, user.getKeyCode());
        preparedStatement.execute();
    }

    public User searchUser(String nameUser, String pass) {
        String sqlSearchUser = "SELECT * FROM user where nameUser = ? and passUser = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSearchUser);
            preparedStatement.setString(1, nameUser);
            preparedStatement.setString(2, pass);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5),
                        resultSet.getInt(6),
                        resultSet.getInt(7)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User searchUserByName(String userName) {
        String sqlSearchUserByName = "select * from user\n" +
                "where nameUser like ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSearchUserByName);
            preparedStatement.setString(1, "%" + userName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5),
                        resultSet.getInt(6),
                        resultSet.getInt(7),
                        resultSet.getInt(8)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public boolean checkKeyCode(int keyCode ) {
//        String sqlSearchUserByName = "select * from user\n" +
//                "where keyCode like ?";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(sqlSearchUserByName);
//            preparedStatement.setString(1, "%" + keyCode + "%");
//            ResultSet resultSet = preparedStatement.execute();
//            while ()
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

    public boolean checkKeyCode(int keycode) {
        String sqlSearchUserByName = "select * from user\n" +
                "where keyCode like ?";
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sqlSearchUserByName);) {
            preparedStatement.setInt(1, keycode);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return rs.getBoolean(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
