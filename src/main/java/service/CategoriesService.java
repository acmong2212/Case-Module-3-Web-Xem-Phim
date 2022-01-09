package service;

import dao.CategoriesDao;
import model.Categories;

import java.util.List;

public class CategoriesService {
    public List<Categories> getAllCategories(){
        return CategoriesDao.getAllCategories();
    }
}
