package com.spring.jdbc.utils;

import com.spring.jdbc.entities.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper  implements RowMapper<Category> {

    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        // object category: blank
        Category category = new Category();
        // atable se data nikalna hai aur category me set krna hai
        category.setId(rs.getInt("id"));
        category.setTitle(rs.getString("title"));
        category.setDescription(rs.getString("description"));
        return category;
    }

}


