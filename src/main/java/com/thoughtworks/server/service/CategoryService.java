package com.thoughtworks.server.service;

import com.thoughtworks.server.model.Category;

import java.util.List;

public interface CategoryService {
    Category getCategoryById(int id);

    void insertCategory(Category category);

    void deleteCategoryById(int id);

    void updateCategoryById(int id);

    List<Category> getCategories();
}
