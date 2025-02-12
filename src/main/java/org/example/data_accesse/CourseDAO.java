package org.example.data_accesse;

import org.example.model.Course;

import java.time.LocalDate;
import java.util.HashSet;

public interface CourseDAO {

    Course saveCourse(Course course);

    Course finfById(int id);

    HashSet<Course> findByName(String name);

    HashSet<Course> findByDate(LocalDate localDate);

    HashSet<Course> findAll();

    boolean removeCourse(Course course);

}
