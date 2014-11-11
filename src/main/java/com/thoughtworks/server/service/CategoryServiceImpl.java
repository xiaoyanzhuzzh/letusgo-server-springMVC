package com.thoughtworks.server.service;

import com.thoughtworks.server.dao.CategoryDao;
import com.thoughtworks.server.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDao categoryDaoImpl;

    @Override
    public Category getCategoryById(int id) {
        return categoryDaoImpl.getCategoryById(id);
    }

    @Override
    public void insertCategory(Category category) {

    }

    @Override
    public void deleteCategoryById(int id) {

    }

    @Override
    public void updateCategoryById(int id) {

    }

    @Override
    public List<Category> getCategories() {
        return categoryDaoImpl.getCategories();
    }
}
