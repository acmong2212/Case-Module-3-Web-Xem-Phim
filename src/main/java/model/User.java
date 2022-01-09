package model;

public class User {
    private int idUser;
    private String nameUser;
    private String passUser;
    private String phoneNumber;
    private int isPremium;
    private int isUser;
    private int isAdmin;
    private int keyCode;

    public User(int idUser, String nameUser, String passUser, String phoneNumber, int isPremium, int isUser, int isAdmin, int keyCode) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.passUser = passUser;
        this.phoneNumber = phoneNumber;
        this.isPremium = isPremium;
        this.isUser = isUser;
        this.isAdmin = isAdmin;
        this.keyCode = keyCode;
    }

    public User(String nameUser, String passUser, String phoneNumber, int isPremium, int isUser, int isAdmin, int keyCode) {
        this.nameUser = nameUser;
        this.passUser = passUser;
        this.phoneNumber = phoneNumber;
        this.isPremium = isPremium;
        this.isUser = isUser;
        this.isAdmin = isAdmin;
        this.keyCode = keyCode;
    }

    public User(int idUser, String nameUser, String passUser, String phoneNumber, int isPremium, int isUser, int isAdmin) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.passUser = passUser;
        this.phoneNumber = phoneNumber;
        this.isPremium = isPremium;
        this.isUser = isUser;
        this.isAdmin = isAdmin;
    }

    public User(String nameUser, String passUser, String phoneNumber, int isPremium, int isUser, int isAdmin) {
        this.nameUser = nameUser;
        this.passUser = passUser;
        this.phoneNumber = phoneNumber;
        this.isPremium = isPremium;
        this.isUser = isUser;
        this.isAdmin = isAdmin;
    }

    public User(String nameUser, String passUser, String phoneNumber, int isUser, int keyCode) {
        this.nameUser = nameUser;
        this.passUser = passUser;
        this.phoneNumber = phoneNumber;
        this.isUser = isUser;
        this.keyCode = keyCode;
    }

    public User(String nameUser, String passUser, String phoneNumber, int isUser) {
        this.nameUser = nameUser;
        this.passUser = passUser;
        this.phoneNumber = phoneNumber;
        this.isUser = isUser;
    }

    public User(int idUser, String nameUser, String passUser, String phoneNumber, int isPremium, int isUser) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.passUser = passUser;
        this.phoneNumber = phoneNumber;
        this.isPremium = isPremium;
        this.isUser = isUser;
    }


    public int getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassUser() {
        return passUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIsPremium() {
        return isPremium;
    }

    public void setIsPremium(int isPremium) {
        this.isPremium = isPremium;
    }

    public int getIsUser() {
        return isUser;
    }

    public void setIsUser(int isUser) {
        this.isUser = isUser;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
}
