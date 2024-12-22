package com.spring.jdbc;

import com.spring.jdbc.dao.CategoryDao;
import com.spring.jdbc.dao.CourseDao;
import com.spring.jdbc.entities.Category;
import com.spring.jdbc.entities.Course;
import com.spring.jdbc.entities.CourseCategoryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {

//	@Autowired
//	private CategoryDao categoryDao;

	@Autowired
	private CourseDao courseDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
		// categoryDao

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application started");
		// category create krne ja rhe hai

		/*
		Category category = new Category();
		category.setId(112);
		category.setTitle("Trending");
		category.setDescription("This is trending category");
		Category savedCategory = categoryDao.save(category);
		System.out.println("category create with is "+savedCategory.getId());
		 */

		/*
		List<Category> categoryList = categoryDao.getAll();
		categoryList.forEach(category -> {
			System.out.println(category.getTitle());
		});
		 */

//		Category category = categoryDao.get(112);
//		System.out.println(category.getTitle());

//		Course course = new Course();
//		course.setCategoryId(112);
//		course.setCourseId(1001);
//		course.setTitle("Microservices course");
//		course.setDescription("This is first course");
//		course.setPrice(8500);
//
//		courseDao.save(course);

//		Course course = courseDao.get(1000);
//		System.out.println(course.getTitle());

//		List<Course> courseByCategory = courseDao.getAll();
//		courseByCategory.forEach(course -> {
//			System.out.print(course.getTitle()+"\n");
//		});

		List<CourseCategoryData> courseCategoryData = courseDao.courseCategoryData();
		courseCategoryData.forEach(data->{
			System.out.println(data.getCourseTitle()+"\t"+data.getCategoryTitle());
		});

	}
}
