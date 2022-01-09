package service;

import dao.UserDao;
import model.User;

import java.util.List;

public class UserService {
    UserDao userDao = new UserDao();

    public List<User> userList = userDao.getAllCategory();

    public List<User> findAll() {
        return userDao.getAllCategory();
    }

    public void createUser(User user) {
        userDao.createUser(user);
    }

    public void deleteUser(int id) {
        userDao.deleteUser(id);
        userList = userDao.getAllCategory();
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
        userList = userDao.getAllCategory();
    }

    public User getUserById(int id){
        for (User user : userList) {
            if (user.getIdUser() == id) {
                return user;
            }
        }
        return null;
    }

    public User searchUser(String nameUser, String pass) {
        return userDao.searchUser(nameUser, pass);
    }

    public User searchUserByName(String name) {
        return userDao.searchUserByName(name);
    }

    public boolean checkKeyCode(int keyCode) {
       return userDao.checkKeyCode(keyCode);
    }

    public User getUserByName(String name){
        for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getNameUser().equals(name)) {
                return userList.get(i);
            }
        }
        return null;
    }
}
