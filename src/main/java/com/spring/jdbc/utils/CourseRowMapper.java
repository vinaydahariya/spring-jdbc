package com.spring.jdbc.utils;

import com.spring.jdbc.entities.Course;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseRowMapper implements RowMapper<Course> {
    @Override
    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
        Course course = new Course();
        course.setCourseId(rs.getInt("courseId"));
        course.setTitle(rs.getString("title"));
        course.setDescription(rs.getString("description"));
        course.setPrice(rs.getInt("price"));
        course.setCategoryId(rs.getInt("categoryId"));  // Make sure to map categoryId
        return course;
    }
}

