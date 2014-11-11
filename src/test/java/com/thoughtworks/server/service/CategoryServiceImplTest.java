package com.thoughtworks.server.service;

import com.thoughtworks.server.dao.CategoryDao;
import com.thoughtworks.server.dao.CategoryDaoImpl;
import com.thoughtworks.server.model.Category;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CategoryServiceImplTest {
    @Before
    public void mock_CategoryDaoImpl(){
        CategoryDao categoryDaoImpl = mock(CategoryDaoImpl.class);
        int id = 1;
        Category category = new Category(1, "水果", 2);
        when(categoryDaoImpl.getCategoryById(id)).thenReturn(category);

        CategoryService categoryServiceImpl = new CategoryServiceImpl();
        categoryServiceImpl.setCategoryDaoImpl(categoryDaoImpl);
    }



    @Test
    public void can_get_category_by_id(){
    }

}
