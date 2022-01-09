package model;

public class Movie {
    private int idMovie;
    private String nameMovie;
    private String description;
    private int idCategories;
    private int year;
    private String image;
    private String nameCategories;

    public Movie() {
    }

    public Movie(int idMovie, String nameMovie, String description, int idCategories, int year, String image, String nameCategories) {
        this.idMovie = idMovie;
        this.nameMovie = nameMovie;
        this.description = description;
        this.idCategories = idCategories;
        this.year = year;
        this.image = image;
        this.nameCategories = nameCategories;
    }

    public Movie(String nameMovie, String description, int idCategories, int year, String image) {
        this.nameMovie = nameMovie;
        this.description = description;
        this.idCategories = idCategories;
        this.year = year;
        this.image = image;
    }

    public Movie(int idMovie, String nameMovie, String description, int idCategories, int year, String image) {
        this.idMovie = idMovie;
        this.nameMovie = nameMovie;
        this.description = description;
        this.idCategories = idCategories;
        this.year = year;
        this.image = image;
    }


    public String getNameCategories() {
        return nameCategories;
    }

    public void setNameCategories(String nameCategories) {
        this.nameCategories = nameCategories;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(int idCategories) {
        this.idCategories = idCategories;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
