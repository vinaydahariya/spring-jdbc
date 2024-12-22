package com.spring.jdbc.service;

import com.spring.jdbc.dao.CategoryDao;
import com.spring.jdbc.dao.CourseDao;
import com.spring.jdbc.entities.Category;
import com.spring.jdbc.entities.Course;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    private CourseDao courseDao;
    private CategoryDao categoryDao;

    public CategoryService(CourseDao courseDao, CategoryDao categoryDao) {
        this.courseDao = courseDao;
        this.categoryDao = categoryDao;
    }

    @Transactional
    public void saveCategoryWithCourse(Category category, Course course){
        categoryDao.save(category);
        courseDao.save(course);
    }
}
