package org.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    // Testing setters
    @Test
    void StudentObjectInitializesSuccessfullyWithValidNameEmailAndAddress() {
        Student bob = new Student("Bob", "Bob@Test.se", "12345 aaaway 45, city");
        assertNotEquals(bob, null);
    }

    @Test
    void nullAsNameThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Student(null, "Bob@Test.se", "12345 aaaway 45, city"));
    }

    @Test
    void emptyNameThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Student(" ", "Bob@Test.se", "12345 aaaway 45, city"));
    }

    @Test
    void nullAsEmailThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Student("Bob", null, "12345 aaaway 45, city"));
    }

    @Test
    void emptyEmailThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Student("Bob", " ", "12345 aaaway 45, city"));
    }

    @Test
    void nullAsAddressThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Student("Bob", "Bob@Test.se", null));
    }

    @Test
    void addressEmailThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Student("Bob", "Bob@Test.se", " "));
    }


    // Test Id
    @Test
    void studentIdIncreasesByOneForEachCreatedStudentObject() {
        Student bob0 = new Student("Bob", "Bob@Test.se", "address");
        Student bob1 = new Student("Bob", "Bob@Test.se", "address");
        Student bob2 = new Student("Bob", "Bob@Test.se", "address");
        Student bob3 = new Student("Bob", "Bob@Test.se", "address");
        Student bob4 = new Student("Bob", "Bob@Test.se", "address");
        assertAll("Id Increases",
                () -> assertEquals(0, bob0.getId()),
                () -> assertEquals(1, bob1.getId()),
                () -> assertEquals(2, bob2.getId()),
                () -> assertEquals(3, bob3.getId()),
                () -> assertEquals(4, bob4.getId())
        );
    }

}