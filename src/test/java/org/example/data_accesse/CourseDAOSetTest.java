package org.example.data_accesse;

import org.example.model.Course;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CourseDAOSetTest {

    // Test saveCourse
    @Test
    void saveCourseAddsTheGivenCourseToTheCoursesCollection() {
        Course math = new Course("Math", LocalDate.now().plusMonths(1), 12);
        CourseDAOSet courseDAOSet = new CourseDAOSet();
        courseDAOSet.saveCourse(math);
        assertTrue(courseDAOSet.findAll().contains(math));
    }


    // Test findById
    @Test
    void findByIdReturnsTheCourseWithTheGivenId() {
        Course math = new Course("Math", LocalDate.now().plusMonths(1), 12);
        CourseDAOSet courseDAOSet = new CourseDAOSet();
        courseDAOSet.saveCourse(math);
        assertEquals(math, courseDAOSet.finfById(0));
    }


    // Test findByName
    @Test
    void findByNameReturnACollectionOfCoursesWithTheGivenName() {
        Course math = new Course("Math", LocalDate.now().plusMonths(1), 12);
        Course math2 = new Course("Math", LocalDate.now().plusMonths(1), 12);
        CourseDAOSet courseDAOSet = new CourseDAOSet();
        courseDAOSet.saveCourse(math);
        courseDAOSet.saveCourse(math2);
        assertEquals(courseDAOSet.findAll(), courseDAOSet.findByName("Math"));
    }

    @Test
    void findByNameThrowsNullPointerExceptionWenTheGivenNameIsNull() {
        Course math2 = new Course("Math", LocalDate.now().plusMonths(1), 12);
        CourseDAOSet courseDAOSet = new CourseDAOSet();
        courseDAOSet.saveCourse(math2);
        assertThrows(NullPointerException.class, () -> courseDAOSet.findByName(null));

    }

    @Test
    void findByNameThrowsIllegalArgumentExceptionWenTheGivenNameIsEmpty() {
        Course math2 = new Course("Math", LocalDate.now().plusMonths(1), 12);
        CourseDAOSet courseDAOSet = new CourseDAOSet();
        courseDAOSet.saveCourse(math2);
        assertThrows(IllegalArgumentException.class, () -> courseDAOSet.findByName(" "));

    }


    // Test findByDate
    @Test
    void findByDateReturnsACollectionWithCoursesWithStartDateAsTheGivenDate() {
        Course math1 = new Course("Math", LocalDate.now().plusMonths(1), 12);
        Course math2 = new Course("Math", LocalDate.now().plusMonths(1), 12);
        CourseDAOSet courseDAOSet = new CourseDAOSet();
        courseDAOSet.saveCourse(math1);
        courseDAOSet.saveCourse(math2);
        assertEquals(courseDAOSet.findAll(), courseDAOSet.findByDate(LocalDate.now().plusMonths(1)));
    }

    @Test
    void findByDateThrowsNullPointerExceptionWhenGivenDateIsNull() {
        Course math1 = new Course("Math", LocalDate.now().plusMonths(1), 12);
        Course math2 = new Course("Math", LocalDate.now().plusMonths(1), 12);
        CourseDAOSet courseDAOSet = new CourseDAOSet();
        courseDAOSet.saveCourse(math1);
        courseDAOSet.saveCourse(math2);
        assertThrows(NullPointerException.class, () -> courseDAOSet.findByDate(null));
    }


    // Test findAll
    @Test
    void sizeOfFindAllIsTwoWhenTowCoursesAreSavedToTheCoursesCollection() {
        Course math1 = new Course("Math", LocalDate.now().plusMonths(1), 12);
        Course math2 = new Course("Math", LocalDate.now().plusMonths(1), 12);
        CourseDAOSet courseDAOSet = new CourseDAOSet();
        courseDAOSet.saveCourse(math1);
        courseDAOSet.saveCourse(math2);
        assertEquals(2, courseDAOSet.findAll().size());
    }


    // Test removeCourse
    @Test
    void removeCourseReturnsTrueAndRemovesTheGivenCourseFromTheCoursesCollectionIfItContainsThatCourse(){
        Course math = new Course("Math", LocalDate.now().plusMonths(1), 12);
        CourseDAOSet courseDAOSet = new CourseDAOSet();
        courseDAOSet.saveCourse(math);
        assertTrue(courseDAOSet.removeCourse(math));
    }

    @Test
    void removeCourseReturnsFalseWhenTheCoursesCollectionDoesNotContainTheGivenCourse(){
        Course math = new Course("Math", LocalDate.now().plusMonths(1), 12);
        CourseDAOSet courseDAOSet = new CourseDAOSet();
        assertFalse(courseDAOSet.removeCourse(math));
    }


}