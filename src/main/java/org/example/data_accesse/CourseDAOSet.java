package org.example.data_accesse;

import org.example.model.Course;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;

public class CourseDAOSet implements CourseDAO {

    private HashSet<Course> courses = new HashSet<>();


    @Override
    public Course saveCourse(Course course) {
        Objects.requireNonNull(course);
        courses.add(course);
        return course;
    }

    @Override
    public Course finfById(int id) {
        Course courseToReturn = null;
        for (Course course : courses) {
            if (course.getId() == id) {
                courseToReturn = course;
                break;
            }
        }
        return courseToReturn;
    }

    @Override
    public HashSet<Course> findByName(String name) {
        Objects.requireNonNull(name);
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException("Name left Empty");
        }
        HashSet<Course> courseToReturn = new HashSet<>();
        for (Course course : courses) {
            if (course.getCourseName().equals(name)) {
                courseToReturn.add(course);
            }
        }

        return courseToReturn;
    }

    @Override
    public HashSet<Course> findByDate(LocalDate localDate) {
        Objects.requireNonNull(localDate);
        HashSet<Course> courseToReturn = new HashSet<>();
        for (Course course : courses) {
            if (course.getStartDate().equals(localDate)) {
                courseToReturn.add(course);
            }
        }

        return courseToReturn;
    }

    @Override
    public HashSet<Course> findAll() {
        return courses;
    }

    @Override
    public boolean removeCourse(Course course) {
        Objects.requireNonNull(course);
        for (Course courseElement : courses) {
            if (course.equals(courseElement)){
                courses.remove(course);
                return true;
            }
        }
        return false;
    }
}
