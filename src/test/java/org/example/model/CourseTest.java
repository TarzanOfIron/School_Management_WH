package org.example.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

class CourseTest {

    // Test set methods
    @Test
    void courseObjectInitializesSuccessfullyWithValidNameStartDateAndWeekDuration() {
        Course math = new Course("Math01", LocalDate.now().plusDays(3), 12);
        assertNotEquals(math, null);
    }

    @Test
    void nullAsCourseNameGiveNullPointerException() {
        assertThrows( NullPointerException.class,() -> {
        Course math = new Course(null, LocalDate.now().plusDays(3), 12);
        });
    }

    @Test
    void emptyCourseNameGiveNullPointerException() {
        assertThrows( IllegalArgumentException.class,() -> {
            Course math = new Course(" ", LocalDate.now().plusDays(3), 12);
        });
    }

    @Test
    void nullAsDateGiveNullPointerException() {
        assertThrows( NullPointerException.class,() -> {
            Course math = new Course("Math", null, 12);
        });
    }

    @Test
    void invalidNumberToWeekDurationGivesIllegalArgumentException() {
        assertThrows( IllegalArgumentException.class,() -> {
            Course math = new Course("Math01", LocalDate.now().plusDays(3), 0);
        });
    }

    // Test methods
    // register
    @Test
    void studentsCollectionContainsTheRegisteredStudent() {
        Student bob = new Student("Bob", "Bob@Test.se", "12345 aaaway 45, city ");
        Course math = new Course("Math01", LocalDate.now().plusDays(3), 12);
        math.register(bob);
        assertTrue(math.getStudents().contains(bob));
    }

    @Test
    void registeringANullObjectThrowsNullPointerException() {
        Course math = new Course("Math01", LocalDate.now().plusDays(3), 12);
        assertThrows(NullPointerException.class, () -> math.register(null));
    }

    // unregister

    @Test
    void studentGetsRemovedFromTheStudentsCollectionAfterUnregisteringThem() {
        Student bob = new Student("Bob", "Bob@Test.se", "12345 aaaway 45, city ");
        Course math = new Course("Math01", LocalDate.now().plusDays(3), 12);
        math.register(bob);
        math.unregister(bob);
        assertFalse(math.getStudents().contains(bob));
    }

    @Test
    void unregisteringANullObjectThrowsNullPointerException() {
        Course math = new Course("Math01", LocalDate.now().plusDays(3), 12);
        assertThrows(NullPointerException.class, () -> math.unregister(null));
    }

    // Test Id
    @Test
    void studentIdIncreasesByOneForEachCreatedStudentObject() {
        Course math0 = new Course("Math1", LocalDate.now().plusMonths(1), 12);
        Course math1 = new Course("Math1", LocalDate.now().plusMonths(1), 12);
        Course math2 = new Course("Math1", LocalDate.now().plusMonths(1), 12);
        Course math3 = new Course("Math1", LocalDate.now().plusMonths(1), 12);
        Course math4 = new Course("Math1", LocalDate.now().plusMonths(1), 12);
        assertAll("Id Increases",
                () -> assertEquals(0, math0.getId()),
                () -> assertEquals(1, math1.getId()),
                () -> assertEquals(2, math2.getId()),
                () -> assertEquals(3, math3.getId()),
                () -> assertEquals(4, math4.getId())
        );
    }



}