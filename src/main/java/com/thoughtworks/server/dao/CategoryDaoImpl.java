package com.thoughtworks.server.dao;

import com.thoughtworks.server.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
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
        }, id);
    }

    @Override
    public void insertCategory(final Category category) {
        String sql = "INSERT INTO categories VALUES(null, ?, ?)";
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, category.getName());
                preparedStatement.setInt(2, category.getNumberOfItem());
            }
        });
    }

    @Override
    public void deleteCategoryById(int id) {
        String sql = "DELETE FROM categories WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateCategoryById(final Category category) {
        String sql = "UPDATE categories SET name = ?, numOfItem = ? WHERE id = ?";
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, category.getName());
                preparedStatement.setInt(2, category.getNumberOfItem());
                preparedStatement.setInt(3, category.getId());
            }
        });
    }

    @Override
    public List<Category> getCategories() {
        String sql = "SELECT * FROM categories";
        return jdbcTemplate.query(sql, new RowMapper<Category>() {
            @Override
            public Category mapRow(ResultSet rs, int i) throws SQLException {
                return new Category(rs.getInt("id"), rs.getString("name"), rs.getInt("numOfItem"));
            }
        });
    }
}
