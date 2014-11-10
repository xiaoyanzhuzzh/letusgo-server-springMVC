package com.thoughtworks.server.dao;

import com.thoughtworks.server.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Category getCategoryById(int id) {
        String sql = "SELECT * FROM categories WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Category>() {
            @Override
            public Category mapRow(ResultSet rs, int i) throws SQLException {
                return new Category(rs.getInt("id"), rs.getString("name"), rs.getInt("numOfItem"));
            }
        });
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
        return null;
    }
}
