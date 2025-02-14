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
        Person bob = new Person("Bob", "Bob@Test.se", "12345 aaaway 45, city ", Role.Student);
        Course math = new Course("Math01", LocalDate.now().plusDays(3), 12);
        math.register(bob);
        assertTrue(math.getPersonStudents().contains(bob));
    }

    @Test
    void registeringANullStudnetObjectThrowsNullPointerException() {
        Course math = new Course("Math01", LocalDate.now().plusDays(3), 12);
        assertThrows(NullPointerException.class, () -> math.register((Student) null));
    }

    @Test
    void registeringANullPersonObjectThrowsNullPointerException() {
        Course math = new Course("Math01", LocalDate.now().plusDays(3), 12);
        assertThrows(NullPointerException.class, () -> math.register((Person) null));
    }

    // unregister

    @Test
    void studentGetsRemovedFromTheStudentsCollectionAfterUnregisteringThem() {
        Person bob = new Person("Bob", "Bob@Test.se", "12345 aaaway 45, city ", Role.Student);
        Course math = new Course("Math01", LocalDate.now().plusDays(3), 12);
        math.register(bob);
        math.unregister(bob);
        assertFalse(math.getPersonStudents().contains(bob));
    }

    @Test
    void unregisteringANullStudnetObjectThrowsNullPointerException() {
        Course math = new Course("Math01", LocalDate.now().plusDays(3), 12);
        assertThrows(NullPointerException.class, () -> math.unregister((Student) null));
    }

    @Test
    void unregisteringANullPersonObjectThrowsNullPointerException() {
        Course math = new Course("Math01", LocalDate.now().plusDays(3), 12);
        assertThrows(NullPointerException.class, () -> math.unregister((Person) null));
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