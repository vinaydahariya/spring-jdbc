package com.spring.jdbc.dao;

import com.spring.jdbc.entities.Category;
import com.spring.jdbc.entities.Course;
import com.spring.jdbc.entities.CourseCategoryData;
import com.spring.jdbc.utils.CourseRowMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CourseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // insert course in batch

    @Transactional
    public void saveCategoryThanCourse(Category category, Course course){

        // inserting category: code
        // create category query
        // jdbc fire: update

        // insert karte course ko
        // create course query
        // jdbc template ki help se fire

        // Insert category
        String categoryQuery = "INSERT INTO categories (id, title, description) VALUES (?, ?, ?)";
        jdbcTemplate.update(categoryQuery, category.getId(), category.getTitle(), category.getDescription());

        // Insert course
        String courseQuery = "INSERT INTO courses (courseId, title, description, price, categoryId) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(courseQuery, course.getCourseId(), course.getTitle(), course.getDescription(), course.getPrice(), category.getId());

    }

    public void saveCourseInBatch(List<Course> list) {
        String query = "INSERT INTO courses (courseId, title, description, price, categoryId) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.batchUpdate(query, list, list.size(), (ps, course) -> {
            ps.setInt(1, course.getCourseId());
            ps.setString(2, course.getTitle());
            ps.setString(3, course.getDescription());
            ps.setInt(4, course.getPrice());
            ps.setInt(5, course.getCategoryId());
        });
        System.out.println("Batch insert completed for " + list.size() + " courses.");
    }


    // Create table
    /*
    @PostConstruct
    public void init() {
        String createTableQuery = """
                CREATE TABLE IF NOT EXISTS courses (
                    courseId INT PRIMARY KEY,
                    title VARCHAR(100) NOT NULL,
                    description VARCHAR(500),
                    price INT
                );
                """;
        jdbcTemplate.update(createTableQuery);
        System.out.println("Courses table created.");
    }
     */

    // Save course
    public Course save(Course course) {
        String query = "INSERT INTO courses (courseId, title, description, price, categoryId) VALUES (?, ?, ?, ?, ?)";
        int rows = jdbcTemplate.update(query, course.getCourseId(), course.getTitle(), course.getDescription(), course.getPrice(), course.getCategoryId());
        System.out.println(rows + " row(s) affected.");
        return course;
    }


    // Update course
    public Course update(int courseId, Course newCourse) {
        String query = "UPDATE courses SET title = ?, description = ?, price = ?, categoryId = ? WHERE courseId = ?";
        int rows = jdbcTemplate.update(query, newCourse.getTitle(), newCourse.getDescription(), newCourse.getPrice(), newCourse.getCategoryId(), courseId);
        System.out.println("Updated " + rows + " row(s).");
        newCourse.setCourseId(courseId);  // Ensure the ID is set
        return newCourse;
    }


    // Get all courses
    public List<Course> getAll() {
        String query = "SELECT * FROM courses";
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            Course course = new Course();
            course.setCourseId(rs.getInt("courseId"));
            course.setTitle(rs.getString("title"));
            course.setDescription(rs.getString("description"));
            course.setPrice(rs.getInt("price"));
            course.setCategoryId(rs.getInt("categoryId"));  // Map categoryId
            return course;
        });
    }

    // Get a course by ID
    public Course get(int courseId) {
        String query = "SELECT * FROM courses WHERE courseId = ?";
        return jdbcTemplate.queryForObject(query, (rs, rowNum) -> {
            Course course = new Course();
            course.setCourseId(rs.getInt("courseId"));
            course.setTitle(rs.getString("title"));
            course.setDescription(rs.getString("description"));
            course.setPrice(rs.getInt("price"));
            course.setCategoryId(rs.getInt("categoryId"));  // Map categoryId
            return course;
        }, courseId);
    }



    // Delete course
    public void delete(int courseId) {
        String query = "DELETE FROM courses WHERE courseId = ?";
        jdbcTemplate.update(query, courseId);
    }

    public List<CourseCategoryData> courseCategoryData() {
        String query = "SELECT \n" +
                "    categories.title AS categoryTitle, \n" +
                "    categories.description AS categoryDesc, \n" +
                "    courses.title AS courseTitle, \n" +
                "    courses.price AS coursePrice, \n" +
                "    courses.description AS courseDesc\n" +
                "FROM \n" +
                "    categories \n" +
                "INNER JOIN \n" +
                "    courses ON categories.id = courses.categoryId;";

        List<CourseCategoryData> courseCategoryData1 = jdbcTemplate.query(query, (rs, rowNum) -> {
            CourseCategoryData courseCategoryData = new CourseCategoryData();
            courseCategoryData.setCategoryTitle(rs.getString("categoryTitle"));
            courseCategoryData.setCategoryDesc(rs.getString("categoryDesc"));
            courseCategoryData.setCourseTitle(rs.getString("courseTitle"));
            // Fetching course price as int
            courseCategoryData.setCoursePrice(rs.getInt("coursePrice"));
            courseCategoryData.setCourseDesc(rs.getString("courseDesc"));
            return courseCategoryData;
        });
        return courseCategoryData1;
    }


}
