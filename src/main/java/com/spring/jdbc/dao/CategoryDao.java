package com.spring.jdbc.dao;

import com.spring.jdbc.entities.Category;
import com.spring.jdbc.utils.CategoryRowMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Repository
public class CategoryDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    // create table
    @PostConstruct
    public void inti(){
        String createTableQuery = "create table if not exists categories(id int primary key, title varchar(100) not null, description varchar(500))";
        jdbcTemplate.update(createTableQuery);
        System.out.println("Table created");
    }


    // save category
    public Category save(Category category){
        // Parameterised query
        String query = "insert into categories (id, title, description) values (?, ?, ?)";
        int rows = jdbcTemplate.update(query,
                category.getId(),
                category.getTitle(),
                category.getDescription());
        System.out.println(rows+" effected");
        return category;
    }

    // update category
    public Category update(int categoryId, Category newCategory){
        String query = "update categories set title = ?, description = ? where id = ?";
        int update =jdbcTemplate.update(query,
                newCategory.getTitle(),
                newCategory.getDescription(),
                categoryId);
        System.out.println("Updated "+update);
        newCategory.setId(categoryId);
        return newCategory;
    }


    // get all category
    public List<Category> getAll(){
        String query = "select *from categories";
//        List<Map<String, Object>> data = jdbcTemplate.queryForList(query);
//        List<Category> categories = jdbcTemplate.queryForList(query, Category.class);
        return jdbcTemplate.query(query, new CategoryRowMapper());
    }


    // get single category by id
    public Category get(int categoryId){
        String query = "select *from categories where id = ?";
        return jdbcTemplate.queryForObject(query, new CategoryRowMapper(), categoryId);
//        return jdbcTemplate.queryForObject(query, new CategoryRowMapper(), categoryId);
    }

    // delete category
    public void delete(int categoryId){
        String query = "delete from categories where id = ?";
        jdbcTemplate.update(query, categoryId);
    }

}
