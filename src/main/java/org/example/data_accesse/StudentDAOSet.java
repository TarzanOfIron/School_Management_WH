package org.example.data_accesse;

import org.example.model.Student;

import java.util.HashSet;
import java.util.Objects;

public class StudentDAOSet implements StudentDAO {

    private HashSet<Student> students = new HashSet<>();


    @Override
    public Student saveStudent(Student student) {
        Objects.requireNonNull(student);
        students.add(student);
        return null;
    }

    @Override
    public Student findByEmail(String email) {
        Objects.requireNonNull(email);
        Student studentToReturn = null;
        for (Student student : students) {
            if (student.getEmail().equals(email)){
                studentToReturn = student;
                break;
            }
        }
        return studentToReturn;
    }

    @Override
    public HashSet<Student> findByName(String name) {
        Objects.requireNonNull(name);
        HashSet<Student> studentsToReturn = new HashSet<>();
        for (Student student : students) {
            if (student.getName().equals(name)){
                studentsToReturn.add(student);
            }
        }
        return studentsToReturn;
    }

    @Override
    public Student findById(int id) {
        Student studentToReturn = null;
        for (Student student : students) {
            if (student.getId() == id){
                studentToReturn = student;
                break;
            }
        }
        return studentToReturn;
    }

    @Override
    public HashSet<Student> findAll() {
        return students;
    }

    @Override
    public boolean deleteStudent(Student student) {
        Objects.requireNonNull(student);
        for (Student studentElement : students) {
            if (studentElement.equals(student)){
                students.remove(student);
                return true;
            }
        }
        return false;
    }
}


