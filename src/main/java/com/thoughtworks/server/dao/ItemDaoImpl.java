package com.thoughtworks.server.dao;

import com.thoughtworks.server.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ItemDaoImpl implements ItemDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Item getItemById(int id) {
        final String sql = "SELECT * FROM items WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, new RowMapper<Item>() {
            @Override
            public Item mapRow(ResultSet rs, int i) throws SQLException {
                return new Item(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"),
                        rs.getString("unit"), rs.getInt("categoryId"));
            }
        }, id);
    }
}
