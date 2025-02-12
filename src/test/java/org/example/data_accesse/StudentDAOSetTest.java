package org.example.data_accesse;

import org.example.model.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOSetTest {

    // Test saveStudent
    @Test
    void saveStudentsAddsTheStudentToTheStudentsCollection() {
        Student bob = new Student("Bob", "Bob@Test.se", "Bobs Address");
        StudentDAOSet studentDAOSet = new StudentDAOSet();
        studentDAOSet.saveStudent(bob);
        assertTrue(studentDAOSet.findAll().contains(bob));
    }


    @Test
    void saveStudentsThrowsExceptionWhenStudentToSaveIsNull() {
        StudentDAOSet studentDAOSet = new StudentDAOSet();
        assertThrows(NullPointerException.class, () -> studentDAOSet.saveStudent(null));
    }


    // Test findByEmail
    @Test
    void findByEmailFindsAndReturnsTheStudentWithGivenEmail() {
        Student bob = new Student("Bob", "Bob@Test.se", "Bobs Address");
        StudentDAOSet studentDAOSet = new StudentDAOSet();
        studentDAOSet.saveStudent(bob);
        assertEquals(bob, studentDAOSet.findByEmail("Bob@Test.se"));
    }


    // Test findByName
    @Test
    void findByNameFindsAndReturnsACollectionOfStudentsWithTheGivenName() {
        Student bob = new Student("Bob", "Bob@Test.se", "Bobs Address");
        Student bob2 = new Student("Bob", "Bob2@Test.se", "Bob2s Address");
        StudentDAOSet studentDAOSet = new StudentDAOSet();
        studentDAOSet.saveStudent(bob);
        assertEquals(studentDAOSet.findAll(), studentDAOSet.findByName("Bob"));
    }


    // Test FindById
    @Test
    void findByIdFindsAndReturnsTheStudentWithGivenId() {
        Student bob = new Student("Bob", "Bob@Test.se", "Bobs Address");
        StudentDAOSet studentDAOSet = new StudentDAOSet();
        studentDAOSet.saveStudent(bob);
        studentDAOSet.saveStudent(new Student("Bob", "Bob2@Test.se", "Bob2s Address"));
        assertEquals(bob, studentDAOSet.findById(0));
    }


    // Test findAll
    @Test
    void sizeOfFindAllIsTwoWhenAddingTwoStudents(){
        StudentDAOSet studentDAOSet = new StudentDAOSet();
        studentDAOSet.saveStudent(new Student("Bob", "Bob2@Test.se", "Bob2s Address"));
        studentDAOSet.saveStudent(new Student("Bob", "Bob2@Test.se", "Bob2s Address"));
        assertEquals(2, studentDAOSet.findAll().size());
    }

    // Test deleteStudent
    @Test
    void deleteStudentReturnsTrueAndRemovesTheGivenStudentFromTheStudentsCollectionIfItContainsIt() {
        Student bob = new Student("Bob", "Bob@Test.se", "Bobs Address");
        StudentDAOSet studentDAOSet = new StudentDAOSet();
        studentDAOSet.saveStudent(bob);
        assertTrue(studentDAOSet.deleteStudent(bob));
    }

    @Test
    void deleteStudentReturnsFalseWhenTheStudentsCollectionDoesNotContainTheGivenStudent() {
        Student bob = new Student("Bob", "Bob@Test.se", "Bobs Address");
        StudentDAOSet studentDAOSet = new StudentDAOSet();
        assertFalse(studentDAOSet.deleteStudent(bob));
    }


}